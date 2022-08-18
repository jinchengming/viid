package com.dyne.viid.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("设备ape对象")
@JsonRootName("APEObject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class APEObject {

    @ApiModelProperty(value = "设备ID")
    @JsonProperty("ApeID")
    @JSONField(name = "ApeID")
    private String ApeID;

    @JsonProperty("Name")
    @ApiModelProperty(value = "名称")
    @JSONField(name = "Name")
    private String Name;

    @JsonProperty("Model")
    @ApiModelProperty(value = "型号")
    @JSONField(name = "Model")
    private String Model;

    @JsonProperty("IPAddr")
    @ApiModelProperty(value = "IP地址")
    @JSONField(name = "IPAddr")
    private String IPAddr;

    @JsonProperty("IPV6Addr")
    @ApiModelProperty(value = "IPV6地址")
    @JSONField(name = "IPV6Addr")
    private String IPV6Addr;

    @JsonProperty("Port")
    @ApiModelProperty(value = "端口号")
    @JSONField(name = "Port")
    private String Port;

    @JsonProperty("Longitude")
    @JSONField(name = "Longitude")
    @ApiModelProperty(value = "经度")
    private String Longitude;

    @JsonProperty("Latitude")
    @ApiModelProperty(value = "纬度")
    @JSONField(name = "Latitude")
    private String Latitude;

    @JsonProperty("PlaceCode")
    @ApiModelProperty(value = "安装地点行政区划代码")
    @JSONField(name = "PlaceCode")
    private String PlaceCode;

    @JsonProperty("Place")
    @JSONField(name = "Place")
    @ApiModelProperty(value = "位置名")
    private String Place;

    @JsonProperty("OrgCode")
    @JSONField(name = "OrgCode")
    @ApiModelProperty(value = "管辖单位代码")
    private String OrgCode;

    @JsonProperty("CapDirection")
    @JSONField(name = "CapDirection")
    @ApiModelProperty(value = "车辆抓拍方向")
    private Integer CapDirection;

    @JsonProperty("MonitorDirection")
    @JSONField(name = "MonitorDirection")
    @ApiModelProperty(value = "监视方向")
    private String MonitorDirection;

    @JsonProperty("MonitorAreaDesc")
    @JSONField(name = "MonitorAreaDesc")
    @ApiModelProperty(value = "监视区域说明")
    private String MonitorAreaDesc;

    @JsonProperty("IsOnline")
    @JSONField(name = "IsOnline")
    @ApiModelProperty(value = "是否在线")
    private String IsOnline;

    @JsonProperty("OwnerApsID")
    @JSONField(name = "OwnerApsID")
    @ApiModelProperty(value = "所属采集系统")
    private String OwnerApsID;


    @ApiModelProperty(value = "用户账号")
    @JsonProperty("UserId")
    @JSONField(name = "UserId")
    private String UserId;

    @ApiModelProperty(value = "口令")
    @JsonProperty("Password")
    @JSONField(name = "Password")
    private String Password;

    @JsonProperty("FunctionType")
    @JSONField(name = "FunctionType")
    private String FunctionType;

    @JsonProperty("PositionType")
    @JSONField(name = "PositionType")
    private String PositionType;
    
}
