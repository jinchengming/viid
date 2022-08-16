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
@ApiModel("场景对象")
@JsonRootName("SceneObject")
public class SceneObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("场景标识")
    @JsonProperty("SceneID")
    @NotBlank(message = "场景标识必须填写.")
    private String sceneId;

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

    @ApiModelProperty("出现时间")
    @JsonProperty("BeginTime")
    private LocalDateTime beginTime;

    @ApiModelProperty("选择处所代码")
    @JsonProperty("PlaceType")
    private String placeType;

    @ApiModelProperty("天气情况分类")
    @JsonProperty("WeatherType")
    private String weatherType;

    @ApiModelProperty("场景描述")
    @JsonProperty("SceneDescribe")
    private String sceneDescribe;

    @ApiModelProperty("道路类型代码")
    @JsonProperty("SceneType")
    private String sceneType;

    @ApiModelProperty("道路线形代码")
    @JsonProperty("RoadAlignmentType")
    private String roadAlignmentType;

    @ApiModelProperty("道路地形分类")
    @JsonProperty("RoadTerrainType")
    private Integer roadTerrainType;

    @ApiModelProperty("道路路面类型代码")
    @JsonProperty("RoadSurfaceType")
    private String roadSurfaceType;

    @ApiModelProperty("道路路面状况代码")
    @JsonProperty("RoadCoditionType")
    private String roadCoditionType;

    @ApiModelProperty("道路路口路段类型代码")
    @JsonProperty("RoadJunctionSectionType")
    private String roadJunctionSectionType;

    @ApiModelProperty("道路照明条件代码")
    @JsonProperty("RoadLightingType")
    private String roadLightingType;

    @ApiModelProperty("现场图示")
    @JsonProperty("Illustration")
    private String illustration;

    @ApiModelProperty("现场风向")
    @JsonProperty("WindDirection")
    private String windDirection;

    @ApiModelProperty("现场光线")
    @JsonProperty("Illumination")
    private String illumination;

    @ApiModelProperty("现场条件")
    @JsonProperty("FieldCondition")
    private String fieldCondition;

    @ApiModelProperty("现场温度")
    @JsonProperty("Temperature")
    private String temperature;

    @ApiModelProperty("现场湿度")
    @JsonProperty("Humidity")
    private String humidity;

    @ApiModelProperty("人群聚集程度")
    @JsonProperty("PopulationDensity")
    private String populationDensity;

    @ApiModelProperty("物品密度")
    @JsonProperty("DenseDegree")
    private String denseDegree;

    @ApiModelProperty("场景重要程度")
    @JsonProperty("Importance")
    private String importance;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageList")
    private SubImageList subImageList;
}
