package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("场景对象列表")
@JsonRootName("SceneListObject")
public class SceneListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("场景对象")
    @JsonProperty("SceneObject")
    private List<SceneObject> sceneObjects;
}
