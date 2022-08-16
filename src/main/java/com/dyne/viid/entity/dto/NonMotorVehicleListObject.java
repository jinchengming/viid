package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * NonMotorVehicleListObject
 */
@Data
@ApiModel("非机动车对象列表")
@JsonRootName("NonMotorVehicleListObject")
public class NonMotorVehicleListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("机动车对象")
    @JsonProperty("NonMotorVehicleObject")
    private List<NonMotorVehicleObject> nonMotorVehicleObjects;
}
