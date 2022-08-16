package com.dyne.viid.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * PersonListObject
 */
@Data
@ApiModel("人员对象列表")
@JsonRootName("PersonListObject")
public class PersonListObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("人员对象")
    @JsonProperty("PersonObject")
    private List<PersonObject> personObjects;
}
