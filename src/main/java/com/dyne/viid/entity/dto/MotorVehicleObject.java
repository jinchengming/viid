package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 机动车对象
 */
@Data
@ApiModel("机动车对象")
@JsonRootName("MotorVehicleObject")
public class MotorVehicleObject implements Serializable {

    private static final long serialVersionUID = -104802618694761409L;

    @ApiModelProperty("车辆标识")
    @JsonProperty("MotorVehicleID")
    @NotBlank(message = "车辆标识不能为空.")
    private String MotorVehicleID;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    @NotNull(message = "信息分类必须填写.")
    private Integer InfoKind;

    @ApiModelProperty("来源标识")
    @JsonProperty("SourceID")
    @NotBlank(message = "来源标识必须填写.")
    private String SourceID;

    @ApiModelProperty("关联卡口编号;卡口编码")
    @JsonProperty("TollgateID")
    private String TollgateID;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    private String DeviceID;

    @ApiModelProperty(value = "拍摄时间")
    @JsonProperty("ShotTime")
    private LocalDateTime ShotTime;

    @ApiModelProperty("近景照片")
    @JsonProperty("StorageUrl1")
//    @NotBlank(message = "近景照片不能为空.")
    @Size(max = 256, message = "近景照片字符长度不能超过256.")
    private String StorageUrl1;

    @ApiModelProperty("车牌照片")
    @JsonProperty("StorageUrl2")
    @Size(max = 256, message = "车牌照片字符长度不能超过256.")
    private String StorageUrl2;

    @ApiModelProperty("远景照片")
    @JsonProperty("StorageUrl3")
    @Size(max = 256, message = "远景照片字符长度不能超过256.")
    private String StorageUrl3;

    @ApiModelProperty("合成图")
    @JsonProperty("StorageUrl4")
    @Size(max = 256, message = "合成图字符长度不能超过256.")
    private String StorageUrl4;

    @ApiModelProperty("缩略图")
    @JsonProperty("StorageUrl5")
    @Size(max = 256, message = "缩略图字符长度不能超过256.")
    private String StorageUrl5;

    @ApiModelProperty("左上角 X 坐标")
    @JsonProperty("LeftTopX")
    private Integer LeftTopX;

    @ApiModelProperty("左上角 Y 坐标")
    @JsonProperty("LeftTopY")
    private Integer LeftTopY;

    @ApiModelProperty("右下角 X 坐标")
    @JsonProperty("RightBtmX")
    private Integer RightBtmX;

    @ApiModelProperty("右下角 Y 坐标")
    @JsonProperty("RightBtmY")
    private Integer RightBtmY;

    @ApiModelProperty("位置标记时间")
    @JsonProperty("MarkTime")
    private LocalDateTime MarkTime;

    @ApiModelProperty("车辆出现时间")
    @JsonProperty("AppearTime")
    private LocalDateTime AppearTime;

    @ApiModelProperty("车辆消失时间")
    @JsonProperty("DisappearTime")
    private LocalDateTime DisappearTime;

    @ApiModelProperty("车道号")
    @JsonProperty("LaneNo")
    private Integer LaneNo;

    @ApiModelProperty("有无车牌")
    @JsonProperty("HasPlate")
    private String haspLate;

    @ApiModelProperty("号牌种类")
    @JsonProperty("PlateClass")
    private String PlateClass;

    @ApiModelProperty("车牌颜色")
    @JsonProperty("PlateColor")
    private String PlateColor;

    @ApiModelProperty("车牌号")
    @JsonProperty("PlateNo")
    private String PlateNo;

    @ApiModelProperty("挂车牌号")
    @JsonProperty("PlateNoAttach")
    private String PlateNoAttach;

    @ApiModelProperty("车牌描述")
    @JsonProperty("PlateDescribe")
    @Size(max = 64, message = "车牌描述字符长度不能超过64.")
    private String PlateDescribe;

    @ApiModelProperty("是否套牌")
    @JsonProperty("IsDecked")
    private String IsDecked;

    @ApiModelProperty("是否涂改")
    @JsonProperty("IsAltered")
    private String IsAltered;

    @ApiModelProperty("是否遮挡")
    @JsonProperty("IsCovered")
    private String IsCovered;

    @ApiModelProperty("行驶速度;单位千米每小时（km/h）")
    @JsonProperty("Speed")
    private BigDecimal Speed;

    @ApiModelProperty("行驶方向")
    @JsonProperty("Direction")
    private String Direction;

    @ApiModelProperty("行驶状态代码")
    @JsonProperty("DrivingStatusCode")
    private String DrivingStatusCode;

    @ApiModelProperty("车辆使用性质代码")
    @JsonProperty("UsingPropertiesCode")
    private Integer UsingPropertiesCode;

    @ApiModelProperty("车辆类型")
    @JsonProperty("VehicleClass")
    private String VehicleClass;

    @ApiModelProperty("车辆品牌;被标注车辆的品牌")
    @JsonProperty("VehicleBrand")
    private String VehicleBrand;

    @ApiModelProperty("车辆型号")
    @JsonProperty("VehicleModel")
    private String VehicleModel;

    @ApiModelProperty("车辆年款")
    @JsonProperty("VehicleStyles")
//    @Size(max = 16, message = "车辆年款字符长度不能超过16.")
    private String VehicleStyles;

    @ApiModelProperty("车辆长度")
    @JsonProperty("VehicleLength")
    private Integer VehicleLength;

    @ApiModelProperty("车辆宽度")
    @JsonProperty("VehicleWidth")
    private Integer VehicleWidth;

    @ApiModelProperty("车辆高度")
    @JsonProperty("VehicleHeight")
    private Integer VehicleHeight;

    @ApiModelProperty("车身颜色")
    @JsonProperty("VehicleColor")
    private String VehicleColor;

    @ApiModelProperty("颜色深浅")
    @JsonProperty("VehicleColorDepth")
    private String VehicleColorDepth;

    @ApiModelProperty("车前盖;对车前盖的描述")
    @JsonProperty("VehicleHood")
    @Size(max = 64, message = "车前盖描述字符长度不能超过64.")
    private String VehicleHood;

    @ApiModelProperty("车后盖;对车后盖的描述")
    @JsonProperty("VehicleTrunk")
    @Size(max = 64, message = "车后盖描述字符长度不能超过64.")
    private String VehicleTrunk;

    @ApiModelProperty("车轮;对车轮的描述")
    @JsonProperty("VehicleWheel")
    @Size(max = 64, message = "车轮描述字符长度不能超过64.")
    private String VehicleWheel;

    @ApiModelProperty("车轮印花纹")
    @JsonProperty("WheelPrintedPattern")
    private String WheelPrintedPattern;

    @ApiModelProperty("车窗;对车窗的描述")
    @JsonProperty("VehicleWindow")
    @Size(max = 64, message = "车窗描述字符长度不能超过64.")
    private String VehicleWindow;

    @ApiModelProperty("车顶;对车顶的描述")
    @JsonProperty("VehicleRoof")
    @Size(max = 64, message = "车顶描述字符长度不能超过64.")
    private String VehicleRoof;

    @ApiModelProperty("车门;对车门的描述")
    @JsonProperty("VehicleDoor")
    @Size(max = 64, message = "车门描述字符长度不能超过64.")
    private String VehicleDoor;

    @ApiModelProperty("车侧;对车侧面的描述，不包括门")
    @JsonProperty("SideOfVehicle")
    @Size(max = 64, message = "车侧描述字符长度不能超过64.")
    private String SideOfVehicle;

    @ApiModelProperty("车厢;对车厢的描述")
    @JsonProperty("CarOfVehicle")
    @Size(max = 64, message = "车厢描述字符长度不能超过64.")
    private String CarOfVehicle;

    @ApiModelProperty("后视镜;对后视镜的描述")
    @JsonProperty("RearviewMirror")
    @Size(max = 64, message = "后视镜描述字符长度不能超过64.")
    private String RearviewMirror;

    @ApiModelProperty("底盘;对车底盘的描述")
    @JsonProperty("VehicleChassis")
    @Size(max = 64, message = "底盘描述字符长度不能超过64.")
    private String VehicleChassis;

    @ApiModelProperty("遮挡;对车遮挡物的描述")
    @JsonProperty("VehicleShielding")
    @Size(max = 64, message = "遮挡描述字符长度不能超过64.")
    private String VehicleShielding;

    @ApiModelProperty("贴膜颜色")
    @JsonProperty("FilmColor")
    private String FilmColor;

    @ApiModelProperty("改装标志")
    @JsonProperty("IsModified")
    private String IsModified;

    @ApiModelProperty("撞痕信息")
    @JsonProperty("HitMarkInfo")
    private String HitMarkInfo;

    @ApiModelProperty("车身描述;描述车身上的文字信息，或者车上载物信息")
    @JsonProperty("VehicleBodyDesc")
    @Size(max = 128, message = "车身描述字符长度不能超过128.")
    private String VehicleBodyDesc;

    @ApiModelProperty("车前部物品;当有多个时可用英文半角逗号分隔")
    @JsonProperty("VehicleFrontItem")
    private String VehicleFrontItem;

    @ApiModelProperty("车前部物品描述;对车前部物品数量、颜色、种类等信息的描述")
    @JsonProperty("DescOfFrontItem")
    @Size(max = 256, message = "车前部物品描述字符长度不能超过256.")
    private String DescOfFrontItem;

    @ApiModelProperty("车后部物品;当有多个时可用英文半角逗号分隔")
    @JsonProperty("VehicleRearItem")
    private String VehicleRearItem;

    @ApiModelProperty("车后部物品描述;对车后部物品数量、颜色、种类等信息的描述")
    @JsonProperty("DescOfRearItem")
    @Size(max = 256, message = "车后部物品描述字符长度不能超过256.")
    private String DescOfRearItem;

    @ApiModelProperty("车内人数;车辆内人员数量")
    @JsonProperty("NumOfPassenger")
    private Integer NumOfPassenger;

    @ApiModelProperty("经过时刻;卡口事件有效，过车时间")
    @JsonProperty("PassTime")
    private LocalDateTime PassTime;

    @ApiModelProperty("经过道路名称;车辆被标注时经过的道路名称")
    @JsonProperty("NameOfPassedRoad")
    @Size(max = 64, message = "经过道路名称字符长度不能超过64.")
    private String NameOfPassedRoad;

    @ApiModelProperty("是否可疑车")
    @JsonProperty("IsSuspicious")
    private String IsSuspicious;

    @ApiModelProperty("遮阳板状态;0：收起；1：放下")
    @JsonProperty("Sunvisor")
    private Integer Sunvisor;

    @ApiModelProperty("安全带状态;0：未系；1：有系")
    @JsonProperty("SafetyBelt")
    private Integer SafetyBelt;

    @ApiModelProperty("打电话状态;0：未打电话；1：打电话中")
    @JsonProperty("Calling")
    private Integer Calling;

    @ApiModelProperty("号牌识别可信度;整个号牌号码的识别可信度，以 0～100 数值表示百分比，数值越大可信度越高")
    @JsonProperty("PlateReliability")
    @Size(max = 3, message = "号牌识别可信度字符长度不能超过3.")
    private String PlateReliability;

    @ApiModelProperty("每位号牌号码可信度;号牌号码的识别可信度，以 0～100 数值表示百分比，数值越大可信度越高。按“字符 1-可信度 1，字符 2-可信度 2”方式排 列，中间为英文半角连接线、逗号；例如识别号 牌号码为：苏 B12345，则取值为：”苏-80，B-90 1-90，2-88，3-90，4-67，5-87”")
    @JsonProperty("PlateCharReliability")
    @Size(max = 64, message = "每位号牌号码可信度字符长度不能超过64.")
    private String PlateCharReliability;

    @ApiModelProperty("品牌标志识别可信度;车辆品牌标志可信度；以 0～100 之间数值表示百分比，数值越大可信度越高")
    @JsonProperty("BrandReliability")
    @Size(max = 3, message = "品牌标志识别可信度字符长度不能超过3.")
    private String BrandReliability;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    private SubImageList SubImageList;
//
//    @ApiModelProperty("关联列表")
//    @JsonProperty("RelatedList")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private RelatedList relatedList;
//
//    @ApiModelProperty("关联类型")
//    @JsonProperty("RelatedType")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private String RelatedType;
}
