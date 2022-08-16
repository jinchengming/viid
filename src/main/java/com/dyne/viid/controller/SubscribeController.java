package com.dyne.viid.controller;


import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.annotation.RequireAuth;
import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusListObject;
import com.dyne.viid.common.result.ResponseStatusObject;
import com.dyne.viid.common.validator.ValidatorUtils;
import com.dyne.viid.entity.VmsSubscribe;
import com.dyne.viid.entity.dto.SubscribeListObject;
import com.dyne.viid.entity.dto.SubscribeObject;
import com.dyne.viid.service.VmsSubscribeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cm_fighting
 * @since 2022-07-06
 */
@Slf4j
@RestController
@Api(tags = "1400人脸相关接口")
@RequestMapping(value = "/VIID")
public class SubscribeController {

    @Autowired
    VmsSubscribeService vmsSubscribeService;

    @RequireAuth
    @PostMapping("/Subscribes")
    @LogOperation("批量订阅")
    public ResponseStatusListObject register(@RequestBody SubscribeListObject subscribeListObject) {
        List<ResponseStatusObject> list = new ArrayList<>(subscribeListObject.getSubscribeObjects().size());
        ResponseStatusObject responseStatusObject;
        String errMsg;
        for (SubscribeObject subscribeObject : subscribeListObject.getSubscribeObjects()) {
            // 检验参数
            errMsg = ValidatorUtils.validateEntity(subscribeObject);
            if (StringUtils.isBlank(errMsg)) {
                responseStatusObject = ResponseStatusObject.create(subscribeObject.getSubscribeID(), ConfirmStatusType.OK);
            } else {
                responseStatusObject = ResponseStatusObject.create(subscribeObject.getSubscribeID(), ConfirmStatusType.Validate_Error.getCode(), errMsg);
            }
            list.add(responseStatusObject);
            // 订阅信息入库
            VmsSubscribe vmsSubscribe = new VmsSubscribe();
            BeanUtils.copyProperties(subscribeObject, vmsSubscribe);
            vmsSubscribeService.save(vmsSubscribe);
        }
        return ResponseStatusListObject.create(list);
    }


    @RequireAuth
    @GetMapping("/Subscribes")
    @LogOperation("查询订阅")
    public SubscribeListObject listSubscribe() {
        // todo : 字段筛选
        List<VmsSubscribe> list = vmsSubscribeService.list();
        List<SubscribeObject> collect = list.stream().map(item -> {
            SubscribeObject subscribeObject = new SubscribeObject();
            BeanUtils.copyProperties(item, subscribeObject);
            return subscribeObject;
        }).collect(Collectors.toList());
        SubscribeListObject subscribeListObject = new SubscribeListObject();
        subscribeListObject.setSubscribeObjects(collect);
        return subscribeListObject;
    }


}

