package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * KeepaliveObject
 */
@Data
@ApiModel("保活对象")
@JsonRootName("KeepaliveObject")
public class KeepaliveObject implements Serializable {

    private static final long serialVersionUID = 3103920346722926227L;
    @ApiModelProperty("设备 ID")
    @JsonProperty("DeviceID")
    @NotNull(message = "设备ID不能为空")
    private String deviceId;
}
