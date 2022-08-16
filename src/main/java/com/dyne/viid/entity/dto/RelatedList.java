package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("关系列表")
@JsonRootName("RelatedList")
public class RelatedList implements Serializable {

    @ApiModelProperty("关系列表")
    @JsonProperty("RelatedInfoObject")
    private List<RelatedInfoObject> relatedInfoObjects;

}
