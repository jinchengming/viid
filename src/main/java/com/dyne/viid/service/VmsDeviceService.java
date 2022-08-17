package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsDevice;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-22
 */
public interface VmsDeviceService extends IService<VmsDevice> {

//    VmsDevice getByApeId(String userIdentify);

    void onLineByDeviceId(String deviceId, Long registerTime);

    void offLineByDeviceId(String deviceId);

    String getLocationByUid(String uid);

    VmsDevice getByDeviceID(String userIdentify);

    void keepByDeviceId(String deviceId, Long keepTime);

    void checkKeep();
}
