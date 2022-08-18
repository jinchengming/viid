package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.VmsNotificationLog;
import com.dyne.viid.entity.VmsSubscribe;
import com.dyne.viid.entity.dto.FaceObject;
import com.dyne.viid.entity.dto.PersonObject;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-16
 */
public interface VmsNotificationLogService extends IService<VmsNotificationLog> {

    /*
        通知Ape设备
     */
    void notifyApe(VmsDevice vmsDevice, VmsSubscribe subscribe, Integer executeOperation);

    /*
        通知人脸
     */
    void notifyFace(FaceObject faceObject, VmsSubscribe subscribe, Integer executeOperation);

    /*
        通知人员
     */
    void notifyPerson(PersonObject personObject, VmsSubscribe subscribe, Integer executeOperation);


}
