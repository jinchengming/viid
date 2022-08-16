package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("关系对象")
@JsonRootName("RelatedInfoObject")
public class RelatedInfoObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图像标识")
    @JsonProperty("ImageID")
    private String imageId;


}
