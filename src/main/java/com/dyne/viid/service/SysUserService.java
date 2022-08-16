package com.dyne.viid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyne.viid.entity.SysUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-15
 */
public interface SysUserService extends IService<SysUser> {

    String login(String username, String password);
}
