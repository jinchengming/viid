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

    @ApiModelProperty(value = "订阅类别")
    @JsonProperty("SubscribeDetail")
    private String SubscribeDetail;

    @ApiModelProperty(value = "订阅资源目录")
    @JsonProperty("ResourceClass")
    private Integer ResourceClass;

    @ApiModelProperty(value = "订阅资源路径")
    @JsonProperty("ResourceURI")
    private String ResourceURI;

    @ApiModelProperty(value = "申请人")
    @JsonProperty("ApplicantName")
    private String ApplicantName;

    @ApiModelProperty(value = "申请单位")
    @JsonProperty("ApplicantOrg")
    private String ApplicantOrg;

    @ApiModelProperty(value = "开始时间")
    @JsonProperty("BeginTime")
    private LocalDateTime BeginTime;

    @ApiModelProperty(value = "结束时间")
    @JsonProperty("EndTime")
    private LocalDateTime EndTime;

    @ApiModelProperty(value = "信息接收地址")
    @JsonProperty("ReceiveAddr")
    private String ReceiveAddr;

    @ApiModelProperty(value = "信息上报间隔")
    @JsonProperty("ReportInterval")
    private Integer ReportInterval;

    @ApiModelProperty(value = "理由")
    @JsonProperty("Reason")
    private String Reason;

    @ApiModelProperty(value = "订阅执行状态，只读0订阅者1已取消2到期9未订阅")
    @JsonProperty("SubscribeStatus")
    private Integer SubscribeStatus;

    @ApiModelProperty(value = "订阅取消单位")
    @JsonProperty("SubscribeCancelOrg")
    private String SubscribeCancelOrg;

    @ApiModelProperty(value = "订阅取消人")
    @JsonProperty("SubscribeCancelPerson")
    private String SubscribeCancelPerson;

    @ApiModelProperty(value = "取消时间")
    @JsonProperty("CancelTime")
    private LocalDateTime CancelTime;

    @ApiModelProperty(value = "取消原因")
    @JsonProperty("CancelReason")
    private String CancelReason;

    @ApiModelProperty(value = "返回结果图片约定")
    @JsonProperty("ResultImageDeclare")
    private String ResultImageDeclare;

    @ApiModelProperty(value = "返回结果特征值约定")
    @JsonProperty("ResultFeatureDeclare")
    private String ResultFeatureDeclare;

    @ApiModelProperty(value = "订阅分类标签标识")
    @JsonProperty("TabID")
    private String TabID;
}
