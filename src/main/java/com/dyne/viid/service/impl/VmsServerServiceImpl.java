package com.dyne.viid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyne.viid.common.utils.DigestUtils;
import com.dyne.viid.entity.VmsServer;
import com.dyne.viid.mapper.VmsServerMapper;
import com.dyne.viid.service.VmsServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cm_fighting
 * @since 2022-08-12
 */
@Service
@Slf4j
public class VmsServerServiceImpl extends ServiceImpl<VmsServerMapper, VmsServer> implements VmsServerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${viid.aps-id}")
    private String myApsId;

    @Override
    public void keepalive() {
        // 查询上级且正常使用状态的平台列表
        List<VmsServer> servers = this.baseMapper.selectList(new QueryWrapper<VmsServer>().eq("type", 1).eq("status", 1));
        // 发送keepalive
        log.info("上级平台数：{}", servers.size());
        for (VmsServer server : servers) {
            if (server.getOnline()) {
                log.info("已注册，发送保活...");
                sendKeepAlive(server);
            } else {
                log.info("未注册，发送注册...");
                sendRegister(server);
            }
        }
    }

    @Override
    public VmsServer getByApsId(String apsId) {
        return this.baseMapper.selectOne(new QueryWrapper<VmsServer>().select("apsId", "type", "username", "password").eq("apsId", apsId));
    }

    /**
     * 发送注册请求 （获取401时 携带的加密信息）
     *
     * @param server 服务器信息
     */
    private void sendRegister(VmsServer server) {
        String url = "http://" + server.getIp() + ":" + server.getPort() + "/VIID/System/Register";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("User-Identify", server.getApsId());
        String param = "{\"RegisterObject\":{\"DeviceID\":" + myApsId + "}}";
        HttpEntity<String> formEntity = new HttpEntity<String>(param, headers);
        //发起post请求
        log.info("registerObject: {}", param);
        ResponseEntity<String> stringResponseEntity = null;
        try {
            stringResponseEntity = restTemplate.postForEntity(url, formEntity, String.class);
            log.info("ResponseEntity----" + stringResponseEntity);
        } catch (HttpClientErrorException e) {
            log.error("e:{}", e.getStatusCode());
            if (e.getStatusCode().is4xxClientError()) {
                HttpHeaders responseHeaders = e.getResponseHeaders();
                log.info("response headers: {}", responseHeaders);
                assert responseHeaders != null;
                List<String> authStrList = responseHeaders.get("WWW-Authenticate");
                if (authStrList != null && authStrList.size() > 0) {
                    String authStr = authStrList.get(0);
                    sendRegister2(server, url, authStr);
                    return;
                }
            }
        } catch (Exception e) {
            log.error("未知错误:{}", e.getMessage());
        }
        if (stringResponseEntity.getStatusCode().is2xxSuccessful()) {
            server.setOnline(true);
            this.updateById(server);
        }
    }


    /**
     * 发送注册请求 （带认证信息）
     *
     * @param server 服务器信息
     */
    private void sendRegister2(VmsServer server, String url, String authStr) {
        String authorization = DigestUtils.generateAuthorization(authStr, server.getUsername(), server.getPassword());
        String param = "{\"RegisterObject\":{\"DeviceID\":" + myApsId + "}}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("User-Identify", myApsId);
        headers.add("Authorization", authorization);
        log.info("param:{}", param);
        log.info("Authorization:{}", authorization);

        HttpEntity<String> formEntity = new HttpEntity<String>(param, headers);
        //发起post请求
        ResponseEntity<String> stringResponseEntity = null;
        try {
            stringResponseEntity = restTemplate.postForEntity(url, formEntity, String.class);
            log.info("ResponseEntity----" + stringResponseEntity);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (stringResponseEntity.getStatusCode().is2xxSuccessful()) {
            server.setOnline(true);
            this.updateById(server);
        }
    }


    /**
     * 发送保活请求
     *
     * @param server 服务器信息
     */
    private void sendKeepAlive(VmsServer server) {
        String url = "http://" + server.getIp() + ":" + server.getPort() + "/VIID/System/Keepalive";
        String param = "{\"KeepaliveObject\":{\"DeviceID\":" + myApsId + "}}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("User-Identify", myApsId);
        log.info("param:{}", param);
        HttpEntity<String> formEntity = new HttpEntity<String>(param, headers);
        //发起post请求
        ResponseEntity<String> stringResponseEntity = null;
        try {
            stringResponseEntity = restTemplate.postForEntity(url, formEntity, String.class);
            log.info("ResponseEntity----" + stringResponseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("自动保活错误：{}", e.getMessage());
            server.setOnline(false);
            this.updateById(server);
        }
    }
}
