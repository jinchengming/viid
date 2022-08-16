package com.dyne.viid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.result.Result;
import com.dyne.viid.entity.VmsServer;
import com.dyne.viid.service.VmsServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-12
 */
@RestController
@RequestMapping("/api/server")
public class VmsServerController {

    @Autowired
    private VmsServerService serverService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping
    public Result save(@RequestBody VmsServer server) {
        boolean save = serverService.save(server);
        if (save) {
            stringRedisTemplate.opsForValue().set(Constants.SERVER_kEY + server.getApsId(), server.getApsId());
        }
        return Result.ok();
    }

    @GetMapping
    public Result page(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<VmsServer> page = serverService.page(new Page<>(pageNum, pageSize), new QueryWrapper<VmsServer>().orderByDesc("id"));
        return Result.ok().data("page", page);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value = "id") Integer id) {
        VmsServer byId = serverService.getById(id);
        if (byId != null) {
            stringRedisTemplate.delete(Constants.SERVER_kEY + byId.getApsId());
            serverService.removeById(id);
        }
        return Result.ok();
    }


    // 主动保活测试接口 （注册+保活）
    @GetMapping("/test")
    public Result test() {
        serverService.keepalive();
        return Result.ok();
    }
}

