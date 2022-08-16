package com.dyne.viid.scheduled;


import com.dyne.viid.service.VmsServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 向上级平台注册保活定时任务
 */

@EnableScheduling
@Component
@Slf4j
public class RegisterTask {

    @Autowired
    private VmsServerService serverService;

    @Scheduled(fixedDelay = 90000)
    public void task() {
        log.info("register keepalive to superior platform ...");
        serverService.keepalive();
    }

}
