package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestEasyExcel
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 1:52 下午
 * @Version 1.0
 */

public class TestEasyExcel {

    public static void main(String[] args) {
        //easyexcel写操作
        //String filename = "/Users/dicoholic/Downloads/课程分类列表模板.xls";
        //EasyExcel.write(filename,DemoData.class).sheet("课程名称").doWrite(getData());

        String filename = "/Users/dicoholic/Downloads/课程分类列表模板.xls";
        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();

    }

    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
//            data.setSno(i);
            data.setName("lucy"+i);
            list.add(data);
        }
        return list;
    }
}
