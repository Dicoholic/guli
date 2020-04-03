package com.atguigu.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName DemoData
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 1:50 下午
 * @Version 1.0
 */
@Data
public class DemoData {

    @ExcelProperty(value = "一级分类",index = 0)
    private String sno;

    @ExcelProperty(value = "二级分类",index = 1)
    private String name;

}
