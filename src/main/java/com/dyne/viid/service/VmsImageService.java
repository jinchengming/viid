package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsImage;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-23
 */
public interface VmsImageService extends IService<VmsImage> {

    Page<VmsImage> pageImg(String apeId, Integer type, Integer pageNum, Integer pageSize);
}
