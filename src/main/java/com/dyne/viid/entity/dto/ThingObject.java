package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("物品对象")
@JsonRootName("ThingObject")
public class ThingObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物品标识")
    @JsonProperty("ThingID")
    @NotBlank(message = "物品标识必须填写.")
    private String thingId;

    @ApiModelProperty("信息分类")
    @JsonProperty("InfoKind")
    @NotNull(message = "信息分类必须填写.")
    private Integer infoKind;

    @ApiModelProperty("来源标识")
    @JsonProperty("SourceID")
    @NotBlank(message = "来源标识必须填写.")
    private String sourceId;

    @ApiModelProperty("设备编码")
    @JsonProperty("DeviceID")
    private String deviceId;

    @ApiModelProperty("左上角 X 坐标")
    @JsonProperty("LeftTopX")
    private Integer leftTopX;

    @ApiModelProperty("左上角 Y 坐标")
    @JsonProperty("LeftTopY")
    private Integer leftTopY;

    @ApiModelProperty("右下角 X 坐标")
    @JsonProperty("RightBtmX")
    private Integer rightBtmX;

    @ApiModelProperty("右下角 Y 坐标")
    @JsonProperty("RightBtmY")
    private Integer rightBtmY;

    @ApiModelProperty("位置标记时间")
    @JsonProperty("LocationMarkTime")
    private LocalDateTime locationMarkTime;

    @ApiModelProperty("出现时间")
    @JsonProperty("AppearTime")
    private LocalDateTime appearTime;

    @ApiModelProperty("消失时间")
    @JsonProperty("DisappearTime")
    private LocalDateTime disappearTime;

    @ApiModelProperty("物品名称")
    @JsonProperty("Name")
    private String name;

    @ApiModelProperty("物品形状")
    @JsonProperty("Shape")
    private String shape;

    @ApiModelProperty("物品颜色")
    @JsonProperty("Color")
    @NotBlank(message = "物品颜色必须填写.")
    private String color;

    @ApiModelProperty("物品大小")
    @JsonProperty("Size")
    private String size;

    @ApiModelProperty("物品材质")
    @JsonProperty("Material")
    private String material;

    @ApiModelProperty("物品特征")
    @JsonProperty("Characteristic")
    private String characteristic;

    @ApiModelProperty("物品性质")
    @JsonProperty("Propertiy")
    private String propertiy;

    @ApiModelProperty("涉案物品类型")
    @JsonProperty("InvolvedObjType")
    private String involvedObjType;

    @ApiModelProperty("枪支弹药类别")
    @JsonProperty("FirearmsAmmunitionType")
    private String firearmsAmmunitionType;

    @ApiModelProperty("工具痕迹代码")
    @JsonProperty("ToolTraceType")
    private String toolTraceType;

    @ApiModelProperty("物证类别")
    @JsonProperty("EvidenceType")
    private String evidenceType;

    @ApiModelProperty("案(事)件物证形态代码")
    @JsonProperty("CaseEvidenceType")
    private String caseEvidenceType;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    private SubImageList subImageList;
}
