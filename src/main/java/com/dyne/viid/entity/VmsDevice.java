package com.dyne.viid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vms_device")
@ApiModel(value = "VmsApe对象", description = "")
@JsonRootName(value = "device")
public class VmsDevice implements Serializable {

    private static final long serialVersionUID = -1852838152455132548L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long ID;

    @ApiModelProperty(value = "设备ID")
    @JsonProperty("ApeID")
    private String ApeID;

    @JsonProperty("Name")
    @ApiModelProperty(value = "名称")
    private String Name;

    @JsonProperty("Model")
    @ApiModelProperty(value = "型号")
    private String Model;

    @JsonProperty("IPAddr")
    @ApiModelProperty(value = "IP地址")
    private String IPAddr;

    @JsonProperty("IPV6Addr")
    @ApiModelProperty(value = "IPV6地址")
    private String IPV6Addr;

    @JsonProperty("Port")
    @ApiModelProperty(value = "端口号")
    private String Port;

    @JsonProperty("Longitude")
    @ApiModelProperty(value = "经度")
    private String Longitude;

    @JsonProperty("Latitude")
    @ApiModelProperty(value = "纬度")
    private String Latitude;

    @JsonProperty("PlaceCode")
    @ApiModelProperty(value = "安装地点行政区划代码")
    private String PlaceCode;

    @JsonProperty("Place")
    @ApiModelProperty(value = "位置名")
    private String Place;

    @JsonProperty("OrgCode")
    @ApiModelProperty(value = "管辖单位代码")
    private String OrgCode;

    @JsonProperty("CapDirection")
    @ApiModelProperty(value = "车辆抓拍方向")
    private Integer CapDirection;

    @JsonProperty("MonitorDirection")
    @ApiModelProperty(value = "监视方向")
    private String MonitorDirection;

    @JsonProperty("MonitorAreaDesc")
    @ApiModelProperty(value = "监视区域说明")
    private String MonitorAreaDesc;

    @JsonProperty("IsOnline")
    @ApiModelProperty(value = "是否在线")
    private String IsOnline;

    @JsonProperty("OwnerApsID")
    @ApiModelProperty(value = "所属采集系统")
    private String OwnerApsID;


    @ApiModelProperty(value = "用户账号")
    @JsonProperty("UserId")
    private String UserId;

    @ApiModelProperty(value = "口令")
    @JsonProperty("Password")
    private String Password;

    @JsonProperty("FunctionType")
    private String FunctionType;

    @JsonProperty("PositionType")
    private String PositionType;

    @JsonProperty("LinkType")
    @ApiModelProperty(value = "级别")
    private Integer LinkType;


    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date CreateTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ModifyTime;

    @JsonProperty("RegisterTime")
    @ApiModelProperty(value = "注册时间")
    private Long RegisterTime;

    @JsonProperty("KeepaliveTime")
    @ApiModelProperty(value = "保活时间")
    private Long KeepaliveTime;


}
