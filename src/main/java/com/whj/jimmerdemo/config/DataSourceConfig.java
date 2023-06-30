package com.whj.jimmerdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static io.vavr.API.List;

@Configuration
@Slf4j
public class DataSourceConfig {

    final
    Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.primary.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.primary.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.primary.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.primary.driver-class-name"));
        dataSource.setInitialSize(0);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(0);
        dataSource.setKeepAlive(false);
        dataSource.setMaxWait(60000);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(100);
        dataSource.setAsyncInit(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        dataSource.setTimeBetweenEvictionRunsMillis(2000L);
        dataSource.setConnectionInitSqls(List(env.getProperty("spring.datasource.primary.connection-init-sql")).toJavaList());
        return dataSource;
    }


    @Bean(name = "jobDataSource")
    public DataSource jobDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.job.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.job.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.job.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.job.driver-class-name"));
        dataSource.setInitialSize(0);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(0);
        dataSource.setKeepAlive(false);
        dataSource.setMaxWait(60000);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(100);
        dataSource.setAsyncInit(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        dataSource.setTimeBetweenEvictionRunsMillis(2000L);
        dataSource.setConnectionInitSqls(List(env.getProperty("spring.datasource.primary.connection-init-sql")).toJavaList());
        return dataSource;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "jobDataSourceTransactionManage")
    public PlatformTransactionManager jobDataSourceTransactionManage(@Qualifier("jobDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
