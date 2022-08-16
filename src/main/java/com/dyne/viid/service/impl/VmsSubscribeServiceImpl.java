package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.entity.VmsSubscribe;
import com.dyne.viid.mapper.VmsSubscribeMapper;
import com.dyne.viid.service.VmsSubscribeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-07-06
 */
@Service
@Slf4j
public class VmsSubscribeServiceImpl extends ServiceImpl<VmsSubscribeMapper, VmsSubscribe> implements VmsSubscribeService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void saveSubscribe(VmsSubscribe vmsSubscribe) {
        Integer operateType = vmsSubscribe.getOperateType();
        if (operateType == 0) {
            createSubscribe(vmsSubscribe);
        } else if (operateType == 1) {
            cancelSubscribe(vmsSubscribe);
        }
    }

    private void createSubscribe(VmsSubscribe vmsSubscribe) {
        String subscribeID = vmsSubscribe.getSubscribeID();
        /*
         * 资源类别。
         * 1-设备
         * 4-视图库
         * 5-行政区划
         */
        Integer resourceClass = vmsSubscribe.getResourceClass();
        String resourceURI = vmsSubscribe.getResourceURI();
        String subscribeDetail = vmsSubscribe.getSubscribeDetail();
        /*
         * 3 采集设备目录
         * 4 采集设备状态
         * 11 自动采集的人员信息
         * 12 自动采集的人脸信息
         * 13 自动采集的车辆信息
         * 14 自动采集的非机动车辆信息
         */
        // 创建订阅
        /*
         *  redis中关于订阅存储数据结构
         *    subscribe
         *          - face
         *          - person
         *          - motor
         *          - non-motor
         *
         * subscribe::11:1  设备
         * subscribe::11:4  视图库 3201 0400 0050 3700 0222
         * subscribe::11:5  行政码
         */
        log.info("resource uri : {}, length:{}, sub: {}", resourceURI, resourceURI.length(), resourceURI.substring(10, 13));
        if (resourceClass == 4 || (resourceURI.length() > 15 && resourceURI.substring(10, 13).equals("503"))) {
            resourceClass = 4;
            if (true) {
                throw new RuntimeException("参数错误");
            }
        }
        String[] subDetailArr = subscribeDetail.split(",");
        for (String detail : subDetailArr) {
            stringRedisTemplate.opsForValue().set(Constants.SUBSCRIBE + detail + "::" + resourceClass, resourceURI);
        }
        this.baseMapper.insert(vmsSubscribe);
    }


    private void cancelSubscribe(VmsSubscribe vmsSubscribe) {
        // todo : 取消订阅
        this.baseMapper.update(vmsSubscribe, new QueryWrapper<VmsSubscribe>().eq("SubscribeID", vmsSubscribe.getSubscribeID()));
    }
}
