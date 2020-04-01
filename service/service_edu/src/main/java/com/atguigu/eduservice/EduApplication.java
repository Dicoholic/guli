package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName EduApplication
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/3/31 11:01 下午
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }

}
