package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.VmsServer;
import com.dyne.viid.entity.VmsSubscribe;
import com.dyne.viid.mapper.VmsDeviceMapper;
import com.dyne.viid.service.VmsDeviceService;
import com.dyne.viid.service.VmsNotificationLogService;
import com.dyne.viid.service.VmsServerService;
import com.dyne.viid.service.VmsSubscribeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-22
 */
@Service
@Slf4j
public class VmsDeviceServiceImpl extends ServiceImpl<VmsDeviceMapper, VmsDevice> implements VmsDeviceService {

    @Value("${viid.aps-id}")
    private String apsID;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private VmsServerService vmsServerService;

    @Autowired
    private VmsSubscribeService subscribeService;

    @Autowired
    private VmsNotificationLogService notificationLogService;


//    @Override
//    public VmsDevice getByApeId(String userIdentify) {
//        return this.baseMapper.getByApeId(userIdentify);
//    }

    @Override
    public void onLineByDeviceId(String deviceId, Long registerTime) {
        this.baseMapper.onLineByDeviceId(deviceId, registerTime);
    }

    @Override
    public void offLineByDeviceId(String deviceId) {
        this.baseMapper.offLineByDeviceId(deviceId);
    }

    @Override
    public String getLocationByUid(String uid) {
        VmsDevice byApeId = this.baseMapper.getByApeId(uid);
        if (byApeId != null) {
            return byApeId.getPlace();
        }
        return null;
    }

    // 根据DeviceID 获取注册所需信息： 包括设备和视图平台（下级）
    @Override
    public VmsDevice getByDeviceID(String userIdentify) {
        String s = stringRedisTemplate.opsForValue().get(Constants.SERVER_kEY + userIdentify);
        log.info("is server :{}", s);
        if (StringUtils.isNotBlank(s)) {
            VmsServer server = vmsServerService.getByApsId(userIdentify);
            if (server.getType() == 2 || server.getType() == 3) {
                VmsDevice vmsDevice = new VmsDevice();
                vmsDevice.setUserId(server.getUsername());
                vmsDevice.setPassword(server.getPassword());
                return vmsDevice;
            } else {
                return null;
            }

        }
        return this.baseMapper.getByApeId(userIdentify);
    }

    @Override
    public void keepByDeviceId(String deviceId, Long keepTime) {
        this.baseMapper.keepByDeviceId(deviceId, keepTime);
    }

    @Override
    public void checkKeep() {
        List<VmsDevice> vmsDevices = this.baseMapper.selectList(new QueryWrapper<VmsDevice>().select("ID", "ApeID").eq("IsOnline", 1));
        vmsDevices.forEach(item -> {
            String keepFlag = stringRedisTemplate.opsForValue().get(Constants.KEEP_ALIVE + item.getApeID());
            if (StringUtils.isBlank(keepFlag)) {
                item.setIsOnline("0");
                this.updateById(item);
            }
        });
    }

    @Override
    public void saveApe(VmsDevice device) {
        device.setOwnerApsID(apsID);
        int insert = this.baseMapper.insert(device);
        if (insert > 0){
            // 判断是否订阅
            VmsSubscribe subscribe = subscribeService.subscribed(device.getApeID());
            if(subscribe != null){
                // 发送订阅通知
                notificationLogService.notifyApe(device, subscribe);
            }
        }
    }
}
