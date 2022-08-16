package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsNonMotorVehicle;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-30
 */
public interface VmsNonMotorVehicleService extends IService<VmsNonMotorVehicle> {

    void saveNonMotorVehicleData(VmsNonMotorVehicle vmsNonMotorVehicle, List<VmsImage> vmsImageList);
}
