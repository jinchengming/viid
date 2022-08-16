package com.dyne.viid.service;

import com.dyne.viid.entity.VmsImage;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 描述: 推送消息到告警服务
 *
 * @author cm_fighting
 * @create 2022-07-07 上午10:51
 */
public interface MqService {

    void sendMsgToMQ(String id, String uid, LocalDateTime shotTime, String alarmType, List<VmsImage> vmsImageList);
}
