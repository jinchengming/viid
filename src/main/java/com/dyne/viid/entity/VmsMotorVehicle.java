package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_motor_vehicle")
@ApiModel(value = "VmsMotorVehicle对象", description = "")
public class VmsMotorVehicle implements Serializable {

    private static final long serialVersionUID = -3152746275859227245L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    @ApiModelProperty(value = "车辆标识")
    private String MotorVehicleID;

    @ApiModelProperty(value = "信息分类")
    private Integer InfoKind;

    @ApiModelProperty(value = "来源标识")
    private String SourceID;

    @ApiModelProperty(value = "关联卡口编号")
    private String TollgateID;

    @ApiModelProperty(value = "设备编码")
    private String DeviceID;

    @ApiModelProperty(value = "拍摄时间")
    private LocalDateTime ShotTime;

    @ApiModelProperty(value = "近景照片")
    private String StorageUrl1;

    @ApiModelProperty(value = "车牌照片")
    private String StorageUrl2;

    @ApiModelProperty(value = "远景照片")
    private String StorageUrl3;

    @ApiModelProperty(value = "合成图")
    private String StorageUrl4;

    @ApiModelProperty(value = "缩略图")
    private String StorageUrl5;

    @ApiModelProperty(value = "左上角X坐标")
    private Integer LeftTopX;

    @ApiModelProperty(value = "左上角Y坐标")
    private Integer LeftTopY;

    @ApiModelProperty(value = "右下角X坐标")
    private Integer RightBtmX;

    @ApiModelProperty(value = "右下角Y坐标")
    private Integer RightBtmY;

    @ApiModelProperty(value = "位置标记时间")
    private LocalDateTime MarkTime;

    @ApiModelProperty(value = "车辆出现时间")
    private LocalDateTime AppearTime;

    @ApiModelProperty(value = "车辆消失时间")
    private LocalDateTime DisAppearTime;

    @ApiModelProperty(value = "车道号")
    private Integer LaneNo;

    @ApiModelProperty(value = "有无车牌")
    private String HasPlate;

    @ApiModelProperty(value = "号牌种类")
    private String PlateClass;

    @ApiModelProperty(value = "车牌颜色")
    private String PlateColor;

    @ApiModelProperty(value = "车牌号")
    private String PlateNo;

    @ApiModelProperty(value = "挂车牌号")
    private String PlateNoAttach;

    @ApiModelProperty(value = "车牌描述")
    private String PlateDescribe;

    @ApiModelProperty(value = "是否套牌")
    private String IsDecked;

    @ApiModelProperty(value = "是否涂改")
    private String IsAltered;

    @ApiModelProperty(value = "是否遮挡")
    private String IsCovered;

    @ApiModelProperty(value = "行驶速度")
    private BigDecimal Speed;

    @ApiModelProperty(value = "行驶方向")
    private String Direction;

    @ApiModelProperty(value = "行驶状态代码")
    private String DrivingStatusCode;

    @ApiModelProperty(value = "车辆使用性质代码")
    private Integer UsingPropertiesCode;

    @ApiModelProperty(value = "车辆类型")
    private String VehicleClass;

    @ApiModelProperty(value = "车辆品牌")
    private String VehicleBrand;

    @ApiModelProperty(value = "车辆型号")
    private String VehicleModel;

    @ApiModelProperty(value = "车辆年款")
    private String VehicleStyles;

    @ApiModelProperty(value = "车辆长度")
    private Integer VehicleLength;

    @ApiModelProperty(value = "车辆宽度")
    private Integer VehicleWidth;

    @ApiModelProperty(value = "车辆高度")
    private Integer VehicleHeight;

    @ApiModelProperty(value = "车身颜色")
    private String VehicleColor;

    @ApiModelProperty(value = "颜色深浅")
    private String VehicleColorDepth;

    @ApiModelProperty(value = "车前盖")
    private String VehicleHood;

    @ApiModelProperty(value = "车后盖")
    private String VehicleTrunk;

    @ApiModelProperty(value = "车轮")
    private String VehicleWheel;

    @ApiModelProperty(value = "车轮印花纹")
    private String WheelPrintedPattern;

    @ApiModelProperty(value = "车窗")
    private String VehicleWindow;

    @ApiModelProperty(value = "车顶")
    private String VehicleRoof;

    @ApiModelProperty(value = "车门")
    private String VehicleDoor;

    @ApiModelProperty(value = "车侧")
    private String SideOfVehicle;

    @ApiModelProperty(value = "车厢")
    private String CarOfVehicle;

    @ApiModelProperty(value = "后视镜")
    private String RearviewMirror;

    @ApiModelProperty(value = "底盘")
    private String VehicleChassis;

    @ApiModelProperty(value = "遮挡")
    private String VehicleShielding;

    @ApiModelProperty(value = "贴膜颜色")
    private String FilmColor;

    @ApiModelProperty(value = "改装标志")
    private String IsModified;

    @ApiModelProperty(value = "撞痕信息")
    private String HitMarkInfo;

    @ApiModelProperty(value = "车身藐视")
    private String VehicleBodyDesc;

    @ApiModelProperty(value = "车前部物品")
    private String VehicleFrontItem;

    @ApiModelProperty(value = "车前部物品描述")
    private String DescOfFrontItem;

    @ApiModelProperty(value = "车后部物品")
    private String VehicleRearItem;

    @ApiModelProperty(value = "车后部物品描述")
    private String DescOfRearItem;

    @ApiModelProperty(value = "车内人数")
    private Integer NumOfPassenger;

    @ApiModelProperty(value = "经过时刻")
    private String PassTime;

    @ApiModelProperty(value = "经过道路名称")
    private String NameOfPassedRoad;

    @ApiModelProperty(value = "是否可疑车")
    private String IsSuspicious;

    @ApiModelProperty(value = "遮阳板状态")
    private Integer Sunvisor;

    @ApiModelProperty(value = "安全带状态")
    private Integer SafetyBelt;

    @ApiModelProperty(value = "打电话状态")
    private Integer Calling;

    @ApiModelProperty(value = "号牌识别可信度")
    private String PlateReliability;

    @ApiModelProperty(value = "每位号牌号码可信度")
    private String PlateCharReliability;

    @ApiModelProperty(value = "品牌标志识别可信度")
    private String BrandReliability;

    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ModifyTime;


}
