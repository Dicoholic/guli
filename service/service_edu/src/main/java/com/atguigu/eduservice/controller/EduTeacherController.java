package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.eduservice.vo.input.TeacherQuery;
import com.atguigu.servicebase.config.exception.CustomException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
//解决跨域问题
@CrossOrigin
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("获得所有讲师列表")
    @GetMapping("/findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items",list);
    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("/{id}")
    public R deleteById(@ApiParam(name = "id",value = "讲师ID",required = true)
                               @PathVariable("id")String id){
        boolean b = eduTeacherService.removeById(id);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("分页查询讲师列表")
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageTeacher(@ApiParam("页数")    @PathVariable("current")int current,
                         @ApiParam("记录数")  @PathVariable("limit")int limit){
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        eduTeacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("分页条件查询讲师列表")
    @PostMapping("/pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@ApiParam("页数")    @PathVariable("current")int current,
                                  @ApiParam("记录数")  @PathVariable("limit")int limit,
                                  @ApiParam("查询条件") @RequestBody(required = false) TeacherQuery teacherQuery){
        //  分页
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //  条件
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        //  拼接条件
        if (!StringUtils.isEmpty(teacherQuery.getName())){
            queryWrapper.like("name",teacherQuery.getName());
        }
        if (!StringUtils.isEmpty(teacherQuery.getLevel())){
            queryWrapper.eq("level",teacherQuery.getLevel());
        }
        if (!StringUtils.isEmpty(teacherQuery.getBegin())){
            queryWrapper.ge("gmt_create",teacherQuery.getBegin());
        }
        if (!StringUtils.isEmpty(teacherQuery.getEnd())){
            queryWrapper.le("gmt_create",teacherQuery.getEnd());
        }
        queryWrapper.orderByDesc("gmt_create");
        eduTeacherService.page(pageTeacher, queryWrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("新增讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("根据ID查询讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable("id")String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @ApiOperation("根据ID修改讲师")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        //  自定义异常处理
        try {
            int i = 10/0;
        }catch (Exception e){
            throw new CustomException(20001,"错误");
        }

        boolean update = eduTeacherService.updateById(eduTeacher);
        if (update){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

