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
@ApiModel("订阅通知对象列表")
@JsonRootName("SubscribeNotificationListObject")
public class SubscribeNotificationListObject implements Serializable {
    
    private static final long serialVersionUID = -3294639770143827300L;

    @ApiModelProperty("订阅通知对象对象")
    @JsonProperty("SubscribeNotificationObject")
    private List<SubscribeNotificationObject> subscribeNotificationObject;
}
