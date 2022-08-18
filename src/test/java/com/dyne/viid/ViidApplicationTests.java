package com.dyne.viid;

import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.utils.DateUtils;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.service.VmsDeviceService;
import com.dyne.viid.service.VmsNotificationLogService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;


@SpringBootTest
@Slf4j
class ViidApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    VmsDeviceService vmsDeviceService;

    @Autowired
    VmsNotificationLogService vmsNotificationLogService;


    @Test
    void getNotifyId() {
        String areaCode = "320104000050";
        Long increment = stringRedisTemplate.opsForValue().increment(Constants.NOTIFY_SERIAL);
        Long serial = increment + 100000L;
        String serialStr = serial.toString();
        String timeStr = DateUtils.format(new Date(), "yyyyMMddHHmmss");
        String id = areaCode + "04" + timeStr + serialStr.substring(serialStr.length() - 5);
        System.out.println(id);
    }

    @Test
    void testNotify() {
        VmsDevice device = vmsDeviceService.getByDeviceID("34020000001320007777");
        log.info("device: {}", device);
        vmsNotificationLogService.notifyApe(device, "http://39.130.178.33:8090/VIID/SubscribeNotifications");
    }

}
