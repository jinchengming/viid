package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@ApiModel("图像对象")
@JsonRootName("SubImageInfoObject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubImageInfoObject implements Serializable {


    private static final long serialVersionUID = 5923907556996639562L;

    @ApiModelProperty("图像标识")
    @JsonProperty("ImageID")
    private String ImageID;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    private Integer InfoKind;


    @ApiModelProperty("事件分类")
    @JsonProperty("EventSort")
    private Integer EventSort;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    private String DeviceID;

    @ApiModelProperty("存储路径")
    @JsonProperty("StoragePath")
    private String StoragePath;

    @ApiModelProperty("")
    @JsonProperty("Type")
    private String Type;

    @ApiModelProperty("图像文件格式")
    @JsonProperty("FileFormat")
    private String FileFormat;

    @ApiModelProperty("拍摄时间")
    @JsonProperty("ShotTime")
    private LocalDateTime ShotTime;

    @ApiModelProperty("Title")
    @JsonProperty("Title")
    private String Title;

    @ApiModelProperty("宽度")
    @JsonProperty("Width")
    private Integer Width;

    @ApiModelProperty("")
    @JsonProperty("Height")
    private Integer Height;

    @ApiModelProperty("密级代码")
    @JsonProperty("SecurityLevel")
    private String SecurityLevel;

    @ApiModelProperty("拍摄地点区划内详细地址")
    @JsonProperty("ShotPlaceFullAdress")
    private String ShotPlaceFullAdress;

    @ApiModelProperty("")
    @JsonProperty("Data")
    private String data;

    @ApiModelProperty("内容描述")
    @JsonProperty("ContentDescription")
    private String ContentDescription;

}
