package com.atguigu.eduservice.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.math.BigDecimal;

/**
 * @ClassName CourseInfoVo
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/7 12:24 下午
 * @Version 1.0
 */
@Data
public class CourseInfoVo {

    @ApiModelProperty(value = "课程ID")
    private  String id;

    @ApiModelProperty(value = "课程讲师ID")
    private String teacherId;

    @ApiModelProperty(value = "课程专业ID")
    private String subjectId;

    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程销售价格，设置为0则免费观看")
    private BigDecimal price;

    @ApiModelProperty(value = "课程总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片路径")
    private String cover;

    @ApiModelProperty(value = "课程简介")
    private String description;

}
