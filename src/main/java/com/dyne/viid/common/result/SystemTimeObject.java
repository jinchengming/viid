package com.dyne.viid.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author cm_fighting
 * @create 2022-07-08 上午11:06
 */
@Data
@ApiModel("校时应答状态对象")
@JsonRootName("SystemTimeObject")
@NoArgsConstructor
public class SystemTimeObject implements Serializable {

    @ApiModelProperty("服务器标识符")
    @JsonProperty("VIIDServerID")
    private String VIIDServerID;

    @ApiModelProperty("校时模式")
    @JsonProperty("TimeMode")
    private String TimeMode;

    @ApiModelProperty("日期时间")
    @JsonProperty("LocalTime")
    private LocalDateTime LocalTime;

    @ApiModelProperty("时区")
    @JsonProperty("TimeZone")
    private String TimeZone;

    public SystemTimeObject(String VIIDServerID) {
        this.VIIDServerID = VIIDServerID;
        TimeMode = "1";
        LocalTime = LocalDateTime.now();
        TimeZone = "Asia/Shanghai";
    }
}
