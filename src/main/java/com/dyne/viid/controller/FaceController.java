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
import com.dyne.viid.entity.VmsFace;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.dto.FaceListObject;
import com.dyne.viid.entity.dto.FaceObject;
import com.dyne.viid.entity.dto.SubImageInfoObject;
import com.dyne.viid.entity.dto.SubImageList;
import com.dyne.viid.service.VmsFaceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(tags = "1400人脸相关接口")
@RequestMapping(value = "/VIID")
public class FaceController {

    @Autowired
    private MinioUtils minioUtils;

    @Resource
    private VmsFaceService vmsFaceService;

    @RequireAuth
    @PostMapping("/Faces")
    @LogOperation("人脸批量新增")
    public ResponseStatusListObject register(@RequestBody FaceListObject faceListObject) {
        List<ResponseStatusObject> list = new ArrayList<>(faceListObject.getFaceObjects().size());
        ResponseStatusObject responseStatusObject;
        String errMsg;
        for (FaceObject faceObject : faceListObject.getFaceObjects()) {
            // 检验参数
            errMsg = ValidatorUtils.validateEntity(faceObject);
            if (StringUtils.isBlank(errMsg)) {
                responseStatusObject = ResponseStatusObject.create(faceObject.getFaceID(), ConfirmStatusType.OK);
            } else {
                responseStatusObject = ResponseStatusObject.create(faceObject.getFaceID(), ConfirmStatusType.Validate_Error.getCode(), errMsg);
            }
            list.add(responseStatusObject);
            // 人脸入库
            VmsFace vmsFace = new VmsFace();
            BeanUtils.copyProperties(faceObject, vmsFace);
            SubImageList subImageList = faceObject.getSubImageList();
            List<SubImageInfoObject> subImageInfoObjects = subImageList.getSubImageInfoObjects();
            Set<String> imageIdSet = new HashSet<>(2);
            List<VmsImage> vmsImageList = subImageInfoObjects.stream().map(image -> {
                VmsImage vmsImage = new VmsImage();
                BeanUtils.copyProperties(image, vmsImage);
                // 处理图片
                String base64Data = image.getData();
                String imageID = image.getImageID();
                if (StringUtils.isBlank(imageID)) {
                    imageID = faceObject.getSourceID();
                }
                if (imageIdSet.contains(imageID)) {
                    BigDecimal bigDecimal = new BigDecimal(imageID);
                    BigDecimal newImageId = bigDecimal.add(new BigDecimal("1"));
                    imageID = newImageId.toString();
                } else {
                    imageIdSet.add(imageID);
                }
                String fileName = "face/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + imageID + "_" + image.getType() + "." + image.getFileFormat();
                minioUtils.uploadByBase64(base64Data, fileName);
                // todo 改成读取配置
                String fileSystemHost = "http://36.147.14.40:29001/viid-dev/";
                vmsImage.setStoragePath(fileSystemHost + fileName);
                vmsImage.setFromType(ImageFrom.FACE.getValue());
                vmsImage.setImageID(imageID);
                return vmsImage;
            }).collect(Collectors.toList());
            vmsFaceService.saveFaceData(vmsFace, vmsImageList);
        }
        return ResponseStatusListObject.create(list);
    }

//    @GetMapping("/api/face/list")
//    public Result listFace() {
//        List<VmsFace> list = vmsFaceService.list();
//        return Result.ok().data("list", list);
//    }

    public static void main(String[] args) {
        String imageID = "32011300001317000002022022081217473100001";
        BigDecimal bigDecimal = new BigDecimal(imageID);
        BigDecimal newImageId = bigDecimal.add(new BigDecimal("1"));
        imageID = newImageId.toString();
        System.out.println(imageID);
    }

}


