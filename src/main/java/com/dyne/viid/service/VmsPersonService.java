package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.entity.VmsPerson;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-29
 */
public interface VmsPersonService extends IService<VmsPerson> {

    void savePersonData(VmsPerson vmsPerson, List<VmsImage> vmsImageList);

}
