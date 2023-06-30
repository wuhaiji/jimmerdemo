package com.whj.jimmerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 首先要在@SpringBootApplication排除该类，因为它会读取application.properties文件的spring.datasource.*属性并自动配置单数据源
@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
public class JimmerdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimmerdemoApplication.class, args);
    }


}
