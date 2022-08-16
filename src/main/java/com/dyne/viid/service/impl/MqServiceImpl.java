//package com.dyne.viid.service.impl;
//
//import com.dyne.viid.common.constant.Constants;
//import com.dyne.viid.common.enums.AlarmMsgType;
//import com.dyne.viid.common.enums.ImageType;
//import com.dyne.viid.entity.VmsImage;
//import com.dyne.viid.entity.dto.AlarmMsg;
//import com.dyne.viid.service.MqService;
//import com.dyne.viid.service.VmsDeviceService;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.List;
//
///**
// * 描述:
// *
// * @author cm_fighting
// * @create 2022-07-07 上午10:54
// */
//@Service
//public class MqServiceImpl implements MqService {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private VmsDeviceService vmsDeviceService;
//
//    @Async
//    @Override
//    public void sendMsgToMQ(String id, String uid, LocalDateTime shotTime, String alarmType, List<VmsImage> vmsImageList) {
//        AlarmMsg msg = new AlarmMsg();
//        msg.setId(id);
//        msg.setUid(uid);
//
//        msg.setAlarmStatus(1);
//        msg.setAlarmType(alarmType);
//        msg.setContent(null);
//        AlarmMsgType msgType = AlarmMsgType.getByValue(alarmType);
//        if (msgType != null) {
//            for (VmsImage image : vmsImageList) {
//                if (shotTime == null) {
//                    shotTime = image.getShotTime();
//                }
//                switch (msgType) {
//                    case FACE:
//                        if (image.getType().equals(ImageType.FACE.getValue())) {
//                            msg.setSmallImageUrl(image.getStoragePath());
//                        } else if (image.getType().equals(ImageType.SCENE.getValue())) {
//                            msg.setImageUrl(image.getStoragePath());
//                        }
//                        break;
//                    case PERSON:
//                        if (image.getType().equals(ImageType.PERSON.getValue())) {
//                            msg.setSmallImageUrl(image.getStoragePath());
//                        } else if (image.getType().equals(ImageType.SCENE.getValue())) {
//                            msg.setImageUrl(image.getStoragePath());
//                        }
//                        break;
//                    case MOTOR_VEHICLES:
//                        if (image.getType().equals(ImageType.LICENCE_PLATE.getValue())) {
//                            msg.setSmallImageUrl(image.getStoragePath());
//                        } else if (image.getType().equals(ImageType.CAR_BIG.getValue())) {
//                            msg.setImageUrl(image.getStoragePath());
//                        }
//                        break;
//                    case NON_MOTOR_VEHICLES:
//                        if (image.getType().equals(ImageType.NON_MOTOR_VEHICLES.getValue())) {
//                            msg.setSmallImageUrl(image.getStoragePath());
//                        } else if (image.getType().equals(ImageType.SCENE.getValue())) {
//                            msg.setImageUrl(image.getStoragePath());
//                        }
//                        break;
//                }
//            }
//        }
//        // 设备信息拿位置
//        String place = vmsDeviceService.getLocationByUid(uid);
//        msg.setLocation(place);
//        msg.setMsgType(1);
//        msg.setCreateTime(System.currentTimeMillis());
//        msg.setRelationId(null);
//        if (shotTime != null) {
//            long l1 = shotTime.toInstant(ZoneOffset.ofHours(+8)).toEpochMilli();
//            msg.setAlarmTime(l1);
//        } else {
//            msg.setAlarmTime(System.currentTimeMillis());
//        }
//        rabbitTemplate.convertAndSend(Constants.MSG_EXCHANGE, Constants.MSG_ROUTING_KEY, msg);
//    }
//}
