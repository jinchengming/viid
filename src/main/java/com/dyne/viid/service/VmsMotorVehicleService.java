package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsMotorVehicle;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-30
 */
public interface VmsMotorVehicleService extends IService<VmsMotorVehicle> {

    void saveMotorVehicleData(VmsMotorVehicle vmsMotorVehicle, List<VmsImage> vmsImageList);
}
