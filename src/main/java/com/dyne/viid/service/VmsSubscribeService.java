package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsSubscribe;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-07-06
 */
public interface VmsSubscribeService extends IService<VmsSubscribe> {

    void saveSubscribe(VmsSubscribe vmsSubscribe);
}
