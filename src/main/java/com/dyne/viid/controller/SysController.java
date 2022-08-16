package com.dyne.viid.controller;

import com.dyne.viid.common.result.Result;
import com.dyne.viid.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sys")
public class SysController {

    @Autowired
    private SysUserService userService;

    @PostMapping("login")
    public Result login(String username, String password) {
        String token = userService.login(username, password);
        if (token != null) {
            return Result.ok().data("token", token);
        }
        return Result.error().message("用户名或者密码错误");

    }

}
