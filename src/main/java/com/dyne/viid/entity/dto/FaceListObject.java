package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * FaceListObject
 */
@Data
@ApiModel("人脸对象列表")
@JsonRootName("FaceListObject")
public class FaceListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("人脸对象")
    @JsonProperty("FaceObject")
    private List<FaceObject> faceObjects;
}
