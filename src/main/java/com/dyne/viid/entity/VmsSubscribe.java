package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author cm_fighting
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_subscribe")
@ApiModel(value = "VmsSubscribe对象", description = "")
public class VmsSubscribe implements Serializable {

    private static final long serialVersionUID = 2911929226348382354L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    @ApiModelProperty(value = "订阅标识符")
    private String SubscribeID;

    @ApiModelProperty(value = "订阅标题")
    private String Title;


    /**
     * 1 案（事）件目录
     * 2 单个案（事）件内容
     * 3 采集设备目录
     * 4 采集设备状态
     * 5 采集系统目录
     * 6 采集系统状态
     * 7 视频卡口目录
     * 8 单个卡口记录
     * 9 车道目录
     * 10 单个车道记录
     * 11 自动采集的人员信息
     * 12 自动采集的人脸信息
     * 13 自动采集的车辆信息
     * 14 自动采集的非机动车辆信息
     * 15 自动采集的物品信息
     * 16 自动采集的文件信息
     */
    @ApiModelProperty(value = "订阅类别")
    private String SubscribeDetail;

    /**
     * 订阅时必选，指定订阅的
     * 资源类别。
     * 0-卡口
     * 1-设备
     * 2-采集内容
     * 3-案件
     * 4-视图库
     * 5-行政区划
     */
    @ApiModelProperty(value = "订阅资源目录")
    private Integer ResourceClass;

    /**
     * 资源路径 URI
     * 卡口 ID
     * 设备 ID
     * 采集内容 ID
     * 案件 ID
     * 目标视图库 ID
     * 行政区编号 2/4/6 位等
     * 支持批量和单个订阅，多
     * 个路径时使用英文半角
     * 逗号分隔。订阅时必选
     */
    @ApiModelProperty(value = "订阅资源路径")
    private String ResourceURI;

    @ApiModelProperty(value = "申请人")
    private String ApplicantName;

    @ApiModelProperty(value = "申请单位")
    private String ApplicantOrg;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime BeginTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime EndTime;

    @ApiModelProperty(value = "信息接收地址")
    private String ReceiveAddr;

    @ApiModelProperty(value = "信息上报间隔")
    private Integer ReportInterval;

    @ApiModelProperty(value = "理由")
    private String Reason;

    @ApiModelProperty(value = "订阅执行状态，只读0订阅者1已取消2到期9未订阅")
    private Integer SubscribeStatus;

    @ApiModelProperty(value = "订阅取消单位")
    private String SubscribeCancelOrg;

    @ApiModelProperty(value = "订阅取消人")
    private String SubscribeCancelPerson;

    @ApiModelProperty(value = "取消时间")
    private LocalDateTime CancelTime;

    @ApiModelProperty(value = "取消原因")
    private String CancelReason;

    @ApiModelProperty(value = "返回结果图片约定")
    private String ResultImageDeclare;

    @ApiModelProperty(value = "返回结果特征值约定")
    private String ResultFeatureDeclare;

    @ApiModelProperty(value = "订阅分类标签标识")
    private String TabID;

    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ModifyTime;

}
