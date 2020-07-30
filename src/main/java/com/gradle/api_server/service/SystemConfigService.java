package com.gradle.api_server.service;


import com.alibaba.fastjson.JSON;
import com.gradle.api_server.dao.SystemConfigMapper;
import com.gradle.api_server.model.SystemConfig;
import com.gradle.api_server.redis.client.DemoRedisClient;
import com.gradle.api_server.utils.StringUtils;
import com.gradle.api_server.vo.ProResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by DIAN on 2018/12/6.
 */
@Service
public class SystemConfigService {
    Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemConfigMapper systemConfigMapper;

    private ConcurrentHashMap<String,SystemConfig> systemConfigCache = new ConcurrentHashMap<String,SystemConfig>();

    public ProResponseResult create(SystemConfig systemConfig) {
        ProResponseResult proResponseResult = new ProResponseResult();
        systemConfigMapper.insert(systemConfig);
        proResponseResult.setData(systemConfig);
        return proResponseResult;
    }

    public ProResponseResult get(Integer id) {
        ProResponseResult proResponseResult = new ProResponseResult();
        SystemConfig systemConfig =systemConfigMapper.selectByPrimaryKey(id);
        proResponseResult.setData(systemConfig);
        return proResponseResult;
    }

    public ProResponseResult getAll() {
        ProResponseResult proResponseResult = new ProResponseResult();
        List<SystemConfig> systemConfigList= systemConfigMapper.getAll();
        proResponseResult.setData(systemConfigList);
        return proResponseResult;
    }

    public ProResponseResult update(SystemConfig systemConfig) {
        ProResponseResult proResponseResult = new ProResponseResult();
       int result =systemConfigMapper.updateByPrimaryKey(systemConfig);
        proResponseResult.setData(result);
        return proResponseResult;
    }
    public ProResponseResult delete(Integer id) {
        ProResponseResult proResponseResult = new ProResponseResult();
        int result =systemConfigMapper.deleteByPrimaryKey(id);
        proResponseResult.setData(result);
        return proResponseResult;
    }

    public void loadAllSystemConfig(){
        List<SystemConfig> list = systemConfigMapper.getAll();
        for(SystemConfig cfg:list){
            cacheSystemParam(cfg);
        }
        DemoRedisClient.setValueByKey("dddddd", JSON.toJSON(list));
        logger.info("系统配置参数加载完成，共加载"+list.size()+"条数据。");
    }
    public void cacheSystemParam(SystemConfig cfg){
        if(cfg!=null && StringUtils.isNotEmpty(cfg.getParamName())){
            systemConfigCache.putIfAbsent(cfg.getParamName(),cfg);
        }
    }
}
