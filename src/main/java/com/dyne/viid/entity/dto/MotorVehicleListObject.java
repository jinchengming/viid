package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * MotorVehicleListObject
 */
@Data
@ApiModel("机动车对象列表")
@JsonRootName("MotorVehicleListObject")
public class MotorVehicleListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("机动车对象")
    @JsonProperty("MotorVehicleObject")
    private List<MotorVehicleObject> motorVehicleObjects;
}
