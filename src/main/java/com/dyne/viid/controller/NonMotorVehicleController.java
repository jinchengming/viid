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
import com.dyne.viid.entity.VmsNonMotorVehicle;
import com.dyne.viid.entity.dto.NonMotorVehicleListObject;
import com.dyne.viid.entity.dto.NonMotorVehicleObject;
import com.dyne.viid.entity.dto.SubImageInfoObject;
import com.dyne.viid.entity.dto.SubImageList;
import com.dyne.viid.service.VmsNonMotorVehicleService;
import io.swagger.annotations.Api;
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

@Api(tags = "非机动车相关接口")
@RestController
@RequestMapping(value = "/VIID")
public class NonMotorVehicleController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private VmsNonMotorVehicleService vmsNonMotorVehicleService;

    @RequireAuth
    @PostMapping(value = "/NonMotorVehicles")
    @LogOperation("非机动车批量新增")
    public ResponseStatusListObject register(@RequestBody NonMotorVehicleListObject nonMotorVehicleListObject) {

        List<ResponseStatusObject> list = new ArrayList<>(nonMotorVehicleListObject.getNonMotorVehicleObjects().size());
        ResponseStatusObject responseStatusObject;
        String errMsg;
        for (NonMotorVehicleObject nonMotorVehicleObject : nonMotorVehicleListObject.getNonMotorVehicleObjects()) {
            // 检验参数
            errMsg = ValidatorUtils.validateEntity(nonMotorVehicleObject);
            if (StringUtils.isBlank(errMsg)) {
                responseStatusObject = ResponseStatusObject.create(nonMotorVehicleObject.getNonMotorVehicleID(), ConfirmStatusType.OK);
            } else {
                responseStatusObject = ResponseStatusObject.create(nonMotorVehicleObject.getNonMotorVehicleID(), ConfirmStatusType.Validate_Error.getCode(), errMsg);
            }
            list.add(responseStatusObject);
            // 非机动车信息入库
            VmsNonMotorVehicle vmsNonMotorVehicle = new VmsNonMotorVehicle();
            BeanUtils.copyProperties(nonMotorVehicleObject, vmsNonMotorVehicle);
            SubImageList subImageList = nonMotorVehicleObject.getSubImageList();
            List<SubImageInfoObject> subImageInfoObjects = subImageList.getSubImageInfoObjects();
            List<VmsImage> vmsImageList = subImageInfoObjects.stream().map(image -> {
                VmsImage vmsImage = new VmsImage();
                BeanUtils.copyProperties(image, vmsImage);
                // 处理图片
                String base64Data = image.getData();
                String imageID = image.getImageID();
                if (StringUtils.isBlank(imageID)) {
                    imageID = nonMotorVehicleObject.getSourceID();
                }
                String fileName = "nonMotorVehicle/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + imageID + "_" + image.getType() + "." + image.getFileFormat();
                minioUtils.uploadByBase64(base64Data, fileName);
                // todo 改成读取配置
                String fileSystemHost = "http://36.147.14.40:29001/viid-dev/";
                vmsImage.setStoragePath(fileSystemHost + fileName);
                vmsImage.setFromType(ImageFrom.NON_MOTOR_VEHICLES.getValue());

                return vmsImage;
            }).collect(Collectors.toList());
            vmsNonMotorVehicleService.saveNonMotorVehicleData(vmsNonMotorVehicle, vmsImageList);
        }

        return ResponseStatusListObject.create(list);
    }
}
