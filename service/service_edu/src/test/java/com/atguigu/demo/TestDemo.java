package com.atguigu.demo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/3 10:45 上午
 * @Version 1.0
 */

public class TestDemo {

    @Value("${server.port}")
    private static String abc;

    public static void main(String[] args) {
        System.out.println(abc);
    }
}
