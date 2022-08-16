package com.dyne.viid.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回对象
 */
@Data
@ApiModel(value = "分页查询返回对象")
public class PageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总记录数")
    private int totalCount;
    @ApiModelProperty(value = "每页记录数")
    private int pageSize;
    @ApiModelProperty(value = "总页数")
    private int totalPage;
    @ApiModelProperty(value = "当前页数")
    private int currPage;
    @ApiModelProperty(value = "数据集合")
    private List<T> list;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    /**
     * 分页
     */
    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getSize();
        this.currPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }
}