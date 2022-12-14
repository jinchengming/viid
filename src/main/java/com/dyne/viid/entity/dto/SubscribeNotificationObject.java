package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 订阅通知对象
 */
@Data
@ApiModel("订阅通知对象")
@JsonRootName("SubscribeNotificationObject")
public class SubscribeNotificationObject implements Serializable {


    private static final long serialVersionUID = -1621861026435303912L;

    @ApiModelProperty(value = "通知标识")
    @JsonProperty("NotificationID")
    private String NotificationID;

    @ApiModelProperty(value = "订阅标识")
    @JsonProperty("SubscribeID")
    private String SubscribeID;

    @ApiModelProperty(value = "主题目标")
    @JsonProperty("Title")
    private String Title;

    @ApiModelProperty(value = "触发时间")
    @JsonProperty("TriggerTime")
    private LocalDateTime TriggerTime;

    @ApiModelProperty(value = "信息标识")
    @JsonProperty("InfoIDs")
    private String InfoIDs;

    // todo CaseObjectList 视频案件集合

    // todo Tollgate 视频卡口信息集合

    // todo Lane 车道信息数据集

    // todo DeviceList 设备信息数据集

    // todo DeviceStatusList // 针对设备批量订阅方式

    // todo APSObjectList 采集系统

    // todo APSStatusObjectList

    // todo PersonObjectList

    // todo FaceObjectList

    // todo MotorVehicleObjectList

    // todo NonMotorVehicleObjectList

    // todo ThingObjectList

    // todo SceneObjectList

    // todo DataClassTabObjectList

    // 1添加 2修改 3删除
    @ApiModelProperty(value = "更新项目")
    @JsonProperty("ExecuteOperation")
    private Integer ExecuteOperation;
}
