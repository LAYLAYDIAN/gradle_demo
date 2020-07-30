package com.gradle.api_server.dao;
import com.gradle.api_server.model.SystemConfig;

import java.util.List;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);

    List<SystemConfig> getAll();
}