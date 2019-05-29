package com.example.demo.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.property.JdbcProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Java 配置方式注入属性
 */
//注入方法1： @Value 注入，局限性较大，只能注入
//@Configuration
//@PropertySource("classpath:jdbc.properties")
//public class JdbcConfig {
//
//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//}

//注入方法2：通过配置类完成，泛用性最高
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
    @Bean
    public DataSource dataSource(JdbcProperties jdbc) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbc.getUrl());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        return dataSource;
    }
}

//注入方法3：如果一段属性只有一个Bean要使用，则在需要使用的地方直接声明即可
//需要注意的是该类必须有对应属性的set方法，否则会注入失败
//@Configuration
//public class JdbcConfig {
//
//    @Bean
//    // 声明要注入的属性前缀，SpringBoot会自动把相关属性通过set方法注入到DataSource中
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        return dataSource;
//    }
//}
