package com.atguigu.eduservice.vo;

import lombok.Data;

/**
 * @ClassName CoursePublishVo
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/8 5:11 下午
 * @Version 1.0
 */
@Data
public class CoursePublishVo {

    private String id;

    private String title;

    private String cover;

    private Integer lessonNum;

    private String subjectLevelOne;

    private String subjectLevelTwo;

    private String teacherName;

    private String price;

}
