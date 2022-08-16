package com.dyne.viid.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 应答状态对象列表
 */
@Data
@ApiModel("应答状态对象列表")
@JsonRootName("ResponseStatusListObject")
public class ResponseStatusListObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("应答状态对象")
    @JsonProperty("ResponseStatusObject")
    private List<ResponseStatusObject> responseStatusObjectList;

    public static ResponseStatusListObject create(List<ResponseStatusObject> responseStatusObjectList) {
        ResponseStatusListObject responseStatusListObject = new ResponseStatusListObject();
        responseStatusListObject.setResponseStatusObjectList(responseStatusObjectList);
        return responseStatusListObject;
    }
}
