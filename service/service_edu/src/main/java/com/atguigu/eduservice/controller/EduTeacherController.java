package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author dicoholic
 * @since 2020-03-31
 */
@Api(value = "讲师Controller",tags = {"讲师Controller"})
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("获得所有讲师列表")
    @GetMapping("/findAll")
    public List<EduTeacher> findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("/{id}")
    public boolean deleteById(@ApiParam(name = "id",value = "讲师ID",required = true)
                               @PathVariable("id")String id){
        boolean b = eduTeacherService.removeById(id);
        return b;
    }

}

