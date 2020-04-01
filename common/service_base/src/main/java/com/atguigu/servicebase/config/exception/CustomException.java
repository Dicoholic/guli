package com.atguigu.servicebase.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Cu
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/1 12:46 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private Integer code;

    private String msg;

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
