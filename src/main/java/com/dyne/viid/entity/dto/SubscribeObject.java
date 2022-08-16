package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 人脸对象
 */
@Data
@ApiModel("订阅对象")
@JsonRootName("SubscribeObject")
public class SubscribeObject implements Serializable {

    private static final long serialVersionUID = -6883905496723268742L;

    @ApiModelProperty(value = "订阅标识符")
    @JsonProperty("SubscribeID")
    @NotBlank(message = "订阅标识符不能为空.")
    private String SubscribeID;

    @ApiModelProperty(value = "订阅标题")
    @JsonProperty("Title")
    private String Title;

    /**
     * 1. 案件目录
     * 2. 单个案件内容
     * 3. 采集设备目录
     * 4. 采集设备状态
     * 5. 采集系统目录
     * 6. 采集系统状态
     * 7. 视频卡口目录
     * 8. 单个卡口记录
     * 9. 车道目录
     * 10. 单个车道记录
     * 11. 人员
     * 12. 人脸
     * 13. 车辆
     * 14. 非机动车
     * 15. 物品
     * 16. 文件
     * 17. 数据分类标签目录
     */
    @ApiModelProperty(value = "订阅类别")
    @JsonProperty("SubscribeDetail")
    private String SubscribeDetail;

    /**
     * 订阅必选
     * 0 - 卡口
     * 1 - 设备
     * 2 - 采集内容
     * 3 - 案件
     * 4 - 视图库
     * 5 - 行政区划
     */
    @ApiModelProperty(value = "订阅资源目录")
    @JsonProperty("ResourceClass")
    private Integer ResourceClass;

    /**
     * 资源路径 URI(卡口 ID、设备
     * ID、采集内容 ID、案件 ID、
     * 目标视图库 ID、行政区编号
     * 2/4/6 位等)
     * 支持批量和单个订阅，订阅时
     * 必选
     */
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

    @ApiModelProperty(value = "信息上报间隔 单位s")
    @JsonProperty("ReportInterval")
    private Integer ReportInterval;

    @ApiModelProperty(value = "理由")
    @JsonProperty("Reason")
    private String Reason;

    /**
     * 0 - 订阅
     * 1 - 取消订阅
     */
    @ApiModelProperty(value = "操作类型")
    @JsonProperty("OperateType")
    private Integer OperateType;


    /**
     * 0 - 订阅中
     * 1 - 已取消订阅
     * 2 - 订阅到期
     * 9 - 未订阅
     * <p>
     * 只读字段
     */
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

    /**
     * -1 不要图片
     * 其 他 取 值 参 照 GA/T
     * 1400.3-2017 中 Imagetype
     * 的定义：
     * 01 车辆大图
     * 02 车牌彩色小图
     * 03 车牌二值化图
     * 04 驾驶员面部特征图
     * 05 副驾驶面部特征图
     * 06 车标
     * 07 违章合成图
     * 08 过车合成图
     * 09 车辆特写图
     * 10 人员图
     * 11 人脸图
     * 12 非机动车图
     * 13 物品图
     * 14 场景图
     * 100 一般图片
     */
    @ApiModelProperty(value = "返回结果图片约定")
    @JsonProperty("ResultImageDeclare")
    private String ResultImageDeclare;

    /**
     * -1 不要特征值
     * 1 需要返回特征值
     */
    @ApiModelProperty(value = "返回结果特征值约定")
    @JsonProperty("ResultFeatureDeclare")
    private String ResultFeatureDeclare;

    @ApiModelProperty(value = "订阅分类标签标识")
    @JsonProperty("TabID")
    private String TabID;
}
