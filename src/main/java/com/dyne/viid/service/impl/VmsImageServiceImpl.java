package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.mapper.VmsImageMapper;
import com.dyne.viid.service.VmsImageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-23
 */
@Service
public class VmsImageServiceImpl extends ServiceImpl<VmsImageMapper, VmsImage> implements VmsImageService {

    @Override
    public Page<VmsImage> pageImg(String apeId, Integer type, Integer pageNum, Integer pageSize) {
        Page<VmsImage> page = new Page(pageNum, pageSize);
        this.baseMapper.selectPage(page, new QueryWrapper<VmsImage>().eq("DeviceID", apeId).eq(type != 0, "FromType", type).orderByDesc("ShotTime"));
        return page;
    }
}
