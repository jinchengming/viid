package com.dyne.viid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.result.Result;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.VmsImage;
import com.dyne.viid.service.VmsDeviceService;
import com.dyne.viid.service.VmsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cm_fighting
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/api/device")
public class VmsDeviceController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private VmsDeviceService vmsDeviceService;

    @Autowired
    private VmsImageService vmsImageService;


    @PostMapping
    public Result save(@RequestBody VmsDevice device) {
        vmsDeviceService.save(device);
        return Result.ok();
    }

    @PutMapping
    public Result update(@RequestBody VmsDevice device) {
        device.setApeID(null);
        vmsDeviceService.updateById(device);
        return Result.ok();
    }

    @GetMapping
    public Result page(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<VmsDevice> page = vmsDeviceService.page(new Page<>(pageNum, pageSize), new QueryWrapper<VmsDevice>().orderByDesc("CreateTime"));
        return Result.ok().data("page", page);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        VmsDevice byId = vmsDeviceService.getById(id);
        if (byId != null) {
            // todo 其他缓存也要删除
            stringRedisTemplate.delete(Constants.KEEP_ALIVE + byId.getApeID());
            vmsDeviceService.removeById(id);
        }
        return Result.ok();
    }

    @GetMapping("/img")
    public Result pageImg(@RequestParam(value = "apeId") String apeId,
                          @RequestParam(value = "type", defaultValue = "2") Integer type,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<VmsImage> page = vmsImageService.pageImg(apeId, type, pageNum, pageSize);
        return Result.ok().data("page", page);
    }

}

