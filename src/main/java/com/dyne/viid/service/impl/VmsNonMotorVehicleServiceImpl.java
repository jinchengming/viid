package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.enums.AlarmMsgType;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsNonMotorVehicle;
import com.dyne.viid.entity.VmsNonMotorVehicleImage;
import com.dyne.viid.mapper.VmsNonMotorVehicleMapper;
import com.dyne.viid.service.MqService;
import com.dyne.viid.service.VmsImageService;
import com.dyne.viid.service.VmsNonMotorVehicleImageService;
import com.dyne.viid.service.VmsNonMotorVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-30
 */
@Service
public class VmsNonMotorVehicleServiceImpl extends ServiceImpl<VmsNonMotorVehicleMapper, VmsNonMotorVehicle> implements VmsNonMotorVehicleService {

    @Resource
    private VmsImageService imageService;

    @Resource
    private VmsNonMotorVehicleImageService vmsNonMotorVehicleImageService;

    @Autowired
    private MqService mqService;

    @Transactional
    @Override
    public void saveNonMotorVehicleData(VmsNonMotorVehicle vmsNonMotorVehicle, List<VmsImage> vmsImageList) {
        this.baseMapper.insert(vmsNonMotorVehicle);
        for (VmsImage vmsImage : vmsImageList) {
            imageService.save(vmsImage);
            VmsNonMotorVehicleImage vmsNonMotorVehicleImage = new VmsNonMotorVehicleImage();
            vmsNonMotorVehicleImage.setNonMotorVehicleID(vmsNonMotorVehicle.getID());
            vmsNonMotorVehicleImage.setImageID(vmsImage.getID());
            vmsNonMotorVehicleImageService.save(vmsNonMotorVehicleImage);
        }
        mqService.sendMsgToMQ(vmsNonMotorVehicle.getNonMotorVehicleID(), vmsNonMotorVehicle.getDeviceID(), vmsNonMotorVehicle.getShotTime(), AlarmMsgType.NON_MOTOR_VEHICLES.getValue(), vmsImageList);
    }
}
