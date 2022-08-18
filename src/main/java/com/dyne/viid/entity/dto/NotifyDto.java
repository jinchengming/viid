package com.dyne.viid.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class NotifyDto implements Serializable {

    private static final long serialVersionUID = 5410006302286509014L;

    @JsonProperty("SubscribeNotificationListObject")
    @JSONField(name = "SubscribeNotificationListObject")
    private SubscribeNotificationListObject SubscribeNotificationListObject;
}
