package com.dyne.viid.controller;

import cn.hutool.core.date.DateUtil;
import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.enums.ImageFrom;
import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusListObject;
import com.dyne.viid.common.result.ResponseStatusObject;
import com.dyne.viid.common.utils.MinioUtils;
import com.dyne.viid.common.validator.ValidatorUtils;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsMotorVehicle;
import com.dyne.viid.entity.dto.MotorVehicleListObject;
import com.dyne.viid.entity.dto.MotorVehicleObject;
import com.dyne.viid.entity.dto.SubImageInfoObject;
import com.dyne.viid.entity.dto.SubImageList;
import com.dyne.viid.service.VmsMotorVehicleService;
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
@Api(tags = "机动车相关接口")
@RequestMapping(value = "/VIID")
public class MotorVehicleController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private VmsMotorVehicleService vmsMotorVehicleService;

    // 机动车批量新增
    @PostMapping(value = "/MotorVehicles")
    @LogOperation("机动车批量新增")
    public ResponseStatusListObject register(@RequestBody MotorVehicleListObject motorVehicleListObject) {

        List<ResponseStatusObject> list = new ArrayList<>(motorVehicleListObject.getMotorVehicleObjects().size());
        ResponseStatusObject responseStatusObject;
        String errMsg;
        for (MotorVehicleObject motorVehicleObject : motorVehicleListObject.getMotorVehicleObjects()) {
            // 检验参数
            errMsg = ValidatorUtils.validateEntity(motorVehicleObject);
            if (StringUtils.isBlank(errMsg)) {
                responseStatusObject = ResponseStatusObject.create(motorVehicleObject.getMotorVehicleID(), ConfirmStatusType.OK);
            } else {
                responseStatusObject = ResponseStatusObject.create(motorVehicleObject.getMotorVehicleID(), ConfirmStatusType.Validate_Error.getCode(), errMsg);
            }
            list.add(responseStatusObject);
            // 机动车信息入库
            VmsMotorVehicle vmsMotorVehicle = new VmsMotorVehicle();
            BeanUtils.copyProperties(motorVehicleObject, vmsMotorVehicle);
            SubImageList subImageList = motorVehicleObject.getSubImageList();
            List<SubImageInfoObject> subImageInfoObjects = subImageList.getSubImageInfoObjects();
            List<VmsImage> vmsImageList = subImageInfoObjects.stream().map(image -> {
                VmsImage vmsImage = new VmsImage();
                BeanUtils.copyProperties(image, vmsImage);
                // 处理图片
                String base64Data = image.getData();
                String imageID = image.getImageID();
                if (StringUtils.isBlank(imageID)) {
                    imageID = motorVehicleObject.getSourceID();
                }
                String fileName = "motorVehicle/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + imageID + "_" + image.getType() + "." + image.getFileFormat();
                minioUtils.uploadByBase64(base64Data, fileName);
                // todo 改成读取配置
                String fileSystemHost = "http://36.147.14.40:29001/viid-dev/";
                vmsImage.setStoragePath(fileSystemHost + fileName);
                vmsImage.setFromType(ImageFrom.MOTOR_VEHICLES.getValue());
                // todo : 待确认逻辑
                if ("01".equals(vmsImage.getType())) {
                    vmsMotorVehicle.setStorageUrl1(fileSystemHost + fileName);
                }
                return vmsImage;
            }).collect(Collectors.toList());
            vmsMotorVehicleService.saveMotorVehicleData(vmsMotorVehicle, vmsImageList);
        }
        return ResponseStatusListObject.create(list);
    }
}