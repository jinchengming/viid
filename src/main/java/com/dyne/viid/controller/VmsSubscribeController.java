package com.dyne.viid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyne.viid.common.result.Result;
import com.dyne.viid.entity.VmsSubscribe;
import com.dyne.viid.service.VmsSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribe")
public class VmsSubscribeController {

    @Autowired
    private VmsSubscribeService vmsSubscribeService;

    /**
     * 订阅：上级向下级订阅
     * 通常我们服务平台 为下级  公安系统为上级
     * 这里接口返回公安系统向我们平台注册之后 发送的订阅信息列表
     * 这里是web接口 用于查看信息
     * 1400标准接口在SubscribeController中
     */
    @GetMapping("listFromUp")
    public Result page(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<VmsSubscribe> page = vmsSubscribeService.page(new Page<>(pageNum, pageSize), new QueryWrapper<VmsSubscribe>().orderByDesc("BeginTime"));
        return Result.ok().data("page", page);
    }


}
