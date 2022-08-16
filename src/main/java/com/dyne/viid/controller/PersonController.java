package com.dyne.viid.controller;

import cn.hutool.core.date.DateUtil;
import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.annotation.RequireAuth;
import com.dyne.viid.common.enums.ImageFrom;
import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusListObject;
import com.dyne.viid.common.result.ResponseStatusObject;
import com.dyne.viid.common.utils.MinioUtils;
import com.dyne.viid.common.validator.ValidatorUtils;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsPerson;
import com.dyne.viid.entity.dto.PersonListObject;
import com.dyne.viid.entity.dto.PersonObject;
import com.dyne.viid.entity.dto.SubImageInfoObject;
import com.dyne.viid.entity.dto.SubImageList;
import com.dyne.viid.service.VmsPersonService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(tags = "1400人员相关接口")
@RequestMapping(value = "/VIID")
public class PersonController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private VmsPersonService vmsPersonService;

    @RequireAuth
    @PostMapping(value = "/Persons")
    @LogOperation("人员批量新增")
    public ResponseStatusListObject register(@RequestBody PersonListObject personListObject) {
        List<ResponseStatusObject> list = new ArrayList<>(personListObject.getPersonObjects().size());
        ResponseStatusObject responseStatusObject;
        String errMsg;
        for (PersonObject personObject : personListObject.getPersonObjects()) {
            // 检验参数
            errMsg = ValidatorUtils.validateEntity(personObject);
            if (StringUtils.isBlank(errMsg)) {
                responseStatusObject = ResponseStatusObject.create(personObject.getPersonID(), ConfirmStatusType.OK);
            } else {
                responseStatusObject = ResponseStatusObject.create(personObject.getPersonID(), ConfirmStatusType.Validate_Error.getCode(), errMsg);
            }
            list.add(responseStatusObject);
            // 人员入库
            VmsPerson vmsPerson = new VmsPerson();
            BeanUtils.copyProperties(personObject, vmsPerson);
            SubImageList subImageList = personObject.getSubImageList();
            List<SubImageInfoObject> subImageInfoObjects = subImageList.getSubImageInfoObjects();
            List<VmsImage> vmsImageList = subImageInfoObjects.stream().map(image -> {
                VmsImage vmsImage = new VmsImage();
                BeanUtils.copyProperties(image, vmsImage);
                // 处理图片
                String base64Data = image.getData();
                String imageID = image.getImageID();
                if (StringUtils.isBlank(imageID)) {
                    imageID = personObject.getSourceID();
                }
                String fileName = "person/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + imageID + "_" + image.getType() + "." + image.getFileFormat();
                minioUtils.uploadByBase64(base64Data, fileName);
                // todo 改成读取配置
                String fileSystemHost = "http://36.147.14.40:29001/viid-dev/";
                vmsImage.setStoragePath(fileSystemHost + fileName);
                vmsImage.setFromType(ImageFrom.PERSON.getValue());
                return vmsImage;
            }).collect(Collectors.toList());
            vmsPersonService.savePersonData(vmsPerson, vmsImageList);
        }
        return ResponseStatusListObject.create(list);
    }
}
