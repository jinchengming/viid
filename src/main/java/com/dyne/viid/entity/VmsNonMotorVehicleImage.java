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
@TableName("vms_non_motor_vehicle_image")
@ApiModel(value = "VmsNoMotorVehicleImage对象", description = "")
public class VmsNonMotorVehicleImage implements Serializable {

    private static final long serialVersionUID = -3644913138752846469L;

    private Long NonMotorVehicleID;

    private Long ImageID;

}
