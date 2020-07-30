package com.gradle.api_server.common.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description: 数据源配置项
 * @Author: Liu Guo Dian
 * @Date: 2020/7/14 17:36
 * @Version: 1.0
 */
@Configuration
@MapperScan(basePackages = "com.gradle.api_server.dao", sqlSessionTemplateRef = "apiSqlSessionTemplate")
public class DataSourceConfig {
    @Bean(name = "apiDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.api")
    @Primary
    public DataSource rdsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "apiSqlSessionFactory")
    @Primary
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("apiDataSource") DataSource apiDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(apiDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean(name = "apiTransactionManager")
    @Primary
    public DataSourceTransactionManager rdsTransactionManager(@Qualifier("apiDataSource") DataSource rdsDataSource){
        return new DataSourceTransactionManager(rdsDataSource);
    }

    @Bean(name = "apiSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate rdsSqlSessionTemplate(@Qualifier("apiSqlSessionFactory") SqlSessionFactory rdsSqlSessionFactory){
        return new SqlSessionTemplate(rdsSqlSessionFactory);
    }

    @Bean(name = "apiNamedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate rdsNamedParameterJdbcTemplate(@Qualifier("apiDataSource") DataSource rdsDataSource){
        return new NamedParameterJdbcTemplate(rdsDataSource);
    }
}
