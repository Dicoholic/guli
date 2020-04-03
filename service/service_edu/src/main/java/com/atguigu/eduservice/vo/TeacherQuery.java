package com.atguigu.eduservice.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TeacherQuery
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/1 10:53 上午
 * @Version 1.0
 */

@Data
@ApiModel("讲师查询条件")
public class TeacherQuery {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "等级")
    private Integer level;

    @ApiModelProperty(value = "开始时间")
    private String begin;

    @ApiModelProperty(value = "结束时间")
    private String end;

}
