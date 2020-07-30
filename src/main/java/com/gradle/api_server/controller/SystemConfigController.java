package com.gradle.api_server.controller;

import com.gradle.api_server.model.SystemConfig;
import com.gradle.api_server.service.SystemConfigService;
import com.gradle.api_server.vo.ProResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 测试类
 * @Author: Liu Guo Dian
 * @Date: 2020/7/14 8:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("/systemConfig")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;
    /**
     * 获取列表
     */
    @GetMapping
    public ProResponseResult getSystemConfigs() {
        return systemConfigService.getAll();
    }

    /**
     * 获取单个信息
     */
    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public ProResponseResult getSystemConfigById(@PathVariable("id") Integer id) {
        return  systemConfigService.get(id);
    }
    /**
     * 保存
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ProResponseResult createSystemConfig(@RequestBody SystemConfig systemConfig){
           return systemConfigService.create(systemConfig);
    }
    /**
     * 更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ProResponseResult updateSystemConfig(@RequestBody
            SystemConfig systemConfig){
        return systemConfigService.update(systemConfig);
    }
    /**
     * 删除
     * */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ProResponseResult deleteSystemConfig(@PathVariable("id") Integer id){
            return  systemConfigService.delete(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ProResponseResult test(@RequestBody SystemConfig systemConfig) {
        ProResponseResult proResponseResult = new ProResponseResult();

        proResponseResult.setData(systemConfig);
        return proResponseResult;
    }


}
