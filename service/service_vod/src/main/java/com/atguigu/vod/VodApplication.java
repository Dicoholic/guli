package com.atguigu.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName VodApplication
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 2:31 下午
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.atguigu"})
public class VodApplication {

    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class,args);
    }
}
