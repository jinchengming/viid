package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("物品对象列表")
@JsonRootName("ThingListObject")
public class ThingListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物品对象")
    @JsonProperty("ThingObject")
    private List<ThingObject> thingObjects;
}
