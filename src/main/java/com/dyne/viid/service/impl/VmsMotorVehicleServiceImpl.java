package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsMotorVehicle;
import com.dyne.viid.entity.VmsMotorVehicleImage;
import com.dyne.viid.mapper.VmsMotorVehicleMapper;
import com.dyne.viid.service.VmsImageService;
import com.dyne.viid.service.VmsMotorVehicleImageService;
import com.dyne.viid.service.VmsMotorVehicleService;
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
public class VmsMotorVehicleServiceImpl extends ServiceImpl<VmsMotorVehicleMapper, VmsMotorVehicle> implements VmsMotorVehicleService {

    @Resource
    private VmsMotorVehicleImageService vmsMotorVehicleImageService;

    @Resource
    private VmsImageService vmsImageService;


    @Transactional
    @Override
    public void saveMotorVehicleData(VmsMotorVehicle vmsMotorVehicle, List<VmsImage> vmsImageList) {
        this.baseMapper.insert(vmsMotorVehicle);
        for (VmsImage vmsImage : vmsImageList) {
            vmsImageService.save(vmsImage);
            VmsMotorVehicleImage vmsMotorVehicleImage = new VmsMotorVehicleImage();
            vmsMotorVehicleImage.setMotorVehicleID(vmsMotorVehicle.getID());
            vmsMotorVehicleImage.setImageID(vmsImage.getID());
            vmsMotorVehicleImageService.save(vmsMotorVehicleImage);
        }
    }
}
