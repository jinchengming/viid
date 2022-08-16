package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_motor_vehicle_image")
@ApiModel(value = "VmsMotorVehicleImage对象", description = "")
public class VmsMotorVehicleImage implements Serializable {

    private static final long serialVersionUID = -3669360040556312462L;

    private Long MotorVehicleID;

    private Long ImageID;


}
