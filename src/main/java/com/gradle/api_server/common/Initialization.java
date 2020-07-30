package com.gradle.api_server.common;
import com.gradle.api_server.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * 初始化加载项
 * */
@Component
public class Initialization implements ApplicationListener<ApplicationReadyEvent> {
    private Logger LOG = Logger.getLogger(String.valueOf(Initialization.class));
    @Autowired
    private SystemConfigService systemConfigService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOG.info("============= initialize start 初始参数加载 ===========");
       //初始化配置信息
        systemConfigService.loadAllSystemConfig();
        LOG.info("============= initialize end ===========");
    }
}
