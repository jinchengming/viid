package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsFace;
import com.dyne.viid.entity.VmsImage;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-23
 */
public interface VmsFaceService extends IService<VmsFace> {

    void saveFaceData(VmsFace vmsFace, List<VmsImage> vmsImageList);

}
