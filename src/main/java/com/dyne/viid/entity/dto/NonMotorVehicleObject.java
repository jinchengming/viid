package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * 非机动车对象
 */
@Data
@ApiModel("非机动车对象")
@JsonRootName("NonMotorVehicleObject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NonMotorVehicleObject implements Serializable {
    private static final long serialVersionUID = -33166262437482907L;

    @ApiModelProperty("车辆标识")
    @JsonProperty("NonMotorVehicleID")
    @NotBlank(message = "车辆标识不能为空.")
    private String NonMotorVehicleID;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    @NotNull(message = "信息分类必须填写.")
    private Integer InfoKind;

    @ApiModelProperty("来源标识")
    @JsonProperty("SourceID")
    @NotBlank(message = "来源标识必须填写.")
    private String SourceID;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    private String DeviceID;

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

    @ApiModelProperty("有无车牌")
    @JsonProperty("HasPlate")
    @NotNull(message = "有无车牌必须填写.")
    private String HasPlate;

    @ApiModelProperty("号牌种类")
    @JsonProperty("PlateClass")
    @NotBlank(message = "号牌种类必须填写.")
    private String PlateClass;

    @ApiModelProperty("车牌颜色")
    @JsonProperty("PlateColor")
    @NotBlank(message = "车牌颜色必须填写.")
    private String PlateColor;

    @ApiModelProperty("车牌号")
    @JsonProperty("PlateNo")
    @NotBlank(message = "车牌号必须填写.")
    @Size(max = 16, message = "车牌号字符长度不能超过16.")
    private String PlateNo;

    @ApiModelProperty("挂车牌号")
    @JsonProperty("PlateNoAttach")
    @Size(max = 16, message = "挂车牌号字符长度不能超过16.")
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

    @ApiModelProperty("行驶状态代码")
    @JsonProperty("DrivingStatusCode")
    private String DrivingStatusCode;

    @ApiModelProperty("车辆使用性质代码")
    @JsonProperty("UsingPropertiesCode")
    private Integer UsingPropertiesCode;

    @ApiModelProperty("车辆品牌;被标注车辆的品牌")
    @JsonProperty("VehicleBrand")
    @Size(max = 32, message = "车辆品牌字符长度不能超过32.")
    private String VehicleBrand;

    @ApiModelProperty("车辆款型")
    @JsonProperty("VehicleType")
    @Size(max = 64, message = "车辆款型字符长度不能超过64.")
    private String VehicleType;

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
    @Size(max = 2, message = "车轮描述字符长度不能超过2.")
    private String WheelPrintedPattern;

    @ApiModelProperty("车窗;对车窗的描述")
    @JsonProperty("VehicleWindow")
    @Size(max = 64, message = "车窗描述字符长度不能超过64")
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
    private Integer FilmColor;

    @ApiModelProperty("改装标志")
    @JsonProperty("IsModified")
    private Integer IsModified;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    private SubImageList SubImageList;

//    @ApiModelProperty("关联列表")
//    @JsonProperty("RelatedList")
//    private RelatedList relatedList;

}
