package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @author cm_fighting
 * @create 2022-07-06 上午11:18
 */
@Data
@ApiModel("订阅对象列表")
@JsonRootName("SubscribeListObject")
public class SubscribeListObject implements Serializable {


    private static final long serialVersionUID = -1041366524804512841L;

    @ApiModelProperty("订阅对象对象")
    @JsonProperty("SubscribeObject")
    private List<SubscribeObject> subscribeObjects;
}
