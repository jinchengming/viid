package com.dyne.viid.common.result;

import com.dyne.viid.common.utils.HttpContextUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 应答状态对象
 */
@Data
@ApiModel("应答状态对象")
@JsonRootName("ResponseStatusObject")
public class ResponseStatusObject implements Serializable {

    private static final long serialVersionUID = -4477333075790952731L;

    @ApiModelProperty("资源定位符")
    @JsonProperty("RequestURL")
    private String requestUrl;

    @ApiModelProperty("状态码")
    @JsonProperty("StatusCode")
    private Integer statusCode;

    @ApiModelProperty("状态描述")
    @JsonProperty("StatusString")
    private String statusString;

    @ApiModelProperty("资源 ID")
    @JsonProperty("Id")
    private String id;

    @ApiModelProperty("当前时间")
    @JsonProperty("LocalTime")
    private LocalDateTime localTime;

    public static ResponseStatusObject create(ConfirmStatusType confirmStatusType) {
        return create(null, confirmStatusType.getCode(), confirmStatusType.getMsg());
    }

    public static ResponseStatusObject create(String id, ConfirmStatusType confirmStatusType) {
        return create(id, confirmStatusType.getCode(), confirmStatusType.getMsg());
    }

    public static ResponseStatusObject create(String id, Integer statusCode, String statusString) {
        ResponseStatusObject responseStatusObject = new ResponseStatusObject();
        responseStatusObject.setStatusCode(statusCode);
        responseStatusObject.setStatusString(statusString);
        responseStatusObject.setId(id == null ? HttpContextUtils.getUserIdentify() : id);
        responseStatusObject.setLocalTime(LocalDateTime.now());
        responseStatusObject.setRequestUrl(HttpContextUtils.getRequestUrl());
        return responseStatusObject;
    }
}
