package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel("图像列表")
@JsonRootName("SubImageList")
public class SubImageList implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图像列表")
    @JsonProperty("SubImageInfoObject")
    private List<SubImageInfoObject> subImageInfoObjects;
}
