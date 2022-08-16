package com.dyne.viid.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页查询表单
 */
@Data
@ApiModel("分页查询表单")
public class PageForm {

    @ApiModelProperty("页码")
    private Integer pageNumber = 1;

    @ApiModelProperty("每页记录数")
    private Integer pageSize = 10;

}
