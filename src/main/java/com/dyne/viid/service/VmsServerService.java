package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.VmsServer;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-12
 */
public interface VmsServerService extends IService<VmsServer> {

    /**
     * 向上级定时保活
     */
    void keepalive();

    VmsServer getByApsId(String apsId);
}
