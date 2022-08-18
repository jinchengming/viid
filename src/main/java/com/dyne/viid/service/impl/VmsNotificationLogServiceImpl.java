package com.dyne.viid.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.utils.DateUtils;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.VmsNotificationLog;
import com.dyne.viid.entity.dto.*;
import com.dyne.viid.mapper.VmsNotificationLogMapper;
import com.dyne.viid.service.VmsNotificationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-16
 */
@Service
@Slf4j
public class VmsNotificationLogServiceImpl extends ServiceImpl<VmsNotificationLogMapper, VmsNotificationLog> implements VmsNotificationLogService {

    @Value("${viid.area-code}")
    private String areaCode;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void notifyApe(VmsDevice vmsDevice, String url) {
        NotifyDto notifyDto = new NotifyDto();

        SubscribeNotificationListObject listObject = new SubscribeNotificationListObject();
        SubscribeNotificationObject notificationObject = new SubscribeNotificationObject();
        notificationObject.setNotificationID(generateNotifyID());
        notificationObject.setTitle("VIID Subscribe");
        notificationObject.setSubscribeID("320104000050032022081615104300000");
        notificationObject.setTriggerTime(DateUtils.format(new Date(), "yyyyMMddHHmmss"));
        notificationObject.setExecuteOperation(1);
        notificationObject.setInfoIDs(vmsDevice.getApeID());
        APEObject apeObject = new APEObject();
        BeanUtils.copyProperties(vmsDevice, apeObject);
        ArrayList<APEObject> deviceList = new ArrayList<>(1);
        deviceList.add(apeObject);
        notificationObject.setDeviceList(deviceList);
        ArrayList<SubscribeNotificationObject> notifyList = new ArrayList<>();
        notifyList.add(notificationObject);
        listObject.setSubscribeNotificationObject(notifyList);

        notifyDto.setSubscribeNotificationListObject(listObject);
        String jsonStr = JSON.toJSONString(notifyDto);
        log.info("notify json:{}", jsonStr);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("User-Identify", "32010400005037000222");
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonStr, headers);
        //发起post请求
        ResponseEntity<String> stringResponseEntity = null;
        try {
            stringResponseEntity = restTemplate.postForEntity(url, formEntity, String.class);
            log.info("ResponseEntity----" + stringResponseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("通知错误：{}", e.getMessage());
        }
    }

    @Override
    public void notifyFace(FaceObject faceObject) {

    }

    @Override
    public void notifyPerson(PersonObject personObject) {

    }


    /**
     * 320104000050042022081615104300000
     * 1-12 公安机构编码：所在地行政区划编码  如：320104000050
     * 13-14：04表示通知 如：04
     * 15-28：时间 yyyyMMdd 如：20220816151043
     * 5位流水号：00000
     *
     * @return 通知ID
     */
    private String generateNotifyID() {
        Long increment = stringRedisTemplate.opsForValue().increment(Constants.NOTIFY_SERIAL);
        Long serial = increment + 100000L;
        String serialStr = serial.toString();
        String timeStr = DateUtils.format(new Date(), "yyyyMMddHHmmss");
        return areaCode + "04" + timeStr + serialStr.substring(serialStr.length() - 5);
    }


}
