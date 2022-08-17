package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.VmsNotificationLog;
import com.dyne.viid.entity.dto.FaceObject;
import com.dyne.viid.entity.dto.PersonObject;
import com.dyne.viid.mapper.VmsNotificationLogMapper;
import com.dyne.viid.service.VmsNotificationLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-16
 */
@Service
public class VmsNotificationLogServiceImpl extends ServiceImpl<VmsNotificationLogMapper, VmsNotificationLog> implements VmsNotificationLogService {

    @Override
    public void notifyApe(VmsDevice vmsDevice) {
        
    }

    @Override
    public void notifyFace(FaceObject faceObject) {

    }

    @Override
    public void notifyPerson(PersonObject personObject) {

    }
}
