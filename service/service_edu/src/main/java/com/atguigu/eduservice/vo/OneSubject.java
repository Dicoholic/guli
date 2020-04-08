package com.atguigu.eduservice.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OneSubject
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 5:53 下午
 * @Version 1.0
 */
@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> children = new ArrayList<>();

}
