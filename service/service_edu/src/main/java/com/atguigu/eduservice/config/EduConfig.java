package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EduConfig
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/3/31 11:03 下午
 * @Version 1.0
 */
@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduConfig {

    /**
     * 逻辑删除
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
