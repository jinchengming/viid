package com.dyne.viid.controller;


import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.result.ResponseStatusListObject;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-16
 */
@Slf4j
@RestController
@Api(tags = "1400通知相关接口")
@RequestMapping(value = "/VIID")
public class NotificationController {

//    @RequireAuth
//    @PostMapping("/SubscribeNotifications")
//    @LogOperation("订阅通知")
//    public ResponseStatusListObject register(@RequestBody SubscribeNotificationListObject subscribeNotificationListObject) {
//
//        return ResponseStatusListObject.create(null);
//    }

    //    @RequireAuth
    @PostMapping("/SubscribeNotifications")
    @LogOperation("订阅通知")
    public ResponseStatusListObject register(@RequestBody String subscribeNotificationListObject) {
        log.info("通知数据：{}", subscribeNotificationListObject);
        return ResponseStatusListObject.create(null);
    }

}

