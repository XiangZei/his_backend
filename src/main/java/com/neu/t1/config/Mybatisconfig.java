package com.neu.t1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis的配置文件，mybatis的接口文件放在com.neu.t1.dao
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.neu.t1.dao")
public class Mybatisconfig {
}
