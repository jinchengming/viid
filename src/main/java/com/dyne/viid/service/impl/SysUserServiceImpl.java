package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.utils.DigestUtils;
import com.dyne.viid.entity.SysUser;
import com.dyne.viid.mapper.SysUserMapper;
import com.dyne.viid.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String login(String username, String password) {
        List<SysUser> users = this.baseMapper.selectList(new QueryWrapper<SysUser>().eq("username", username));
        if (users.size() > 0) {
            SysUser user = users.get(0);
            if (!DigestUtils.md5(password).equals(user.getPassword())) {
                return null;
            } else {
                String token = UUID.randomUUID().toString().replace("-", "");
                stringRedisTemplate.opsForValue().set(Constants.USER_TOKEN + token, username, Constants.USER_TOKEN_EXPIRE, TimeUnit.SECONDS);
                return token;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5("123456"));


    }

}
