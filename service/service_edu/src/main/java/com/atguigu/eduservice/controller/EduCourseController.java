package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.vo.CourseInfoVo;
import com.atguigu.eduservice.vo.CoursePublishVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-07
 */
@Api(value = "课程Controller",tags = {"课程Controller"})
@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @ApiOperation("条件查询带分页获取课程列表")
    @GetMapping("/list")
    public R getCourseList(){
        List<EduCourse> list = eduCourseService.list(null);
        return R.ok().data("list",list);
    }

    //添加课程基本信息
    @ApiOperation("添加课程")
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        // 返回添加之后课程id
        String cid = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("cid",cid);
    }

    @ApiOperation("根据课程Id查询课程信息")
    @GetMapping("/getCourseById/{id}")
    public R getChapterById(@PathVariable String id){
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        EduCourse course = eduCourseService.getById(id);
        EduCourseDescription description = courseDescriptionService.getById(id);
        BeanUtils.copyProperties(course,courseInfoVo);
        courseInfoVo.setDescription(description.getDescription());
        return R.ok().data("course",courseInfoVo);
    }

    @ApiOperation("修改课程信息")
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        // 返回添加之后课程id
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    @ApiOperation("根据课程Id查询课程确认信息")
    @GetMapping("/getCourseInfoById/{id}")
    public R getCourseInfoById(@PathVariable String id){
        CoursePublishVo publishVo = eduCourseService.getCourseInfoById(id);
        return R.ok().data("publish",publishVo);
    }

    @ApiOperation("发布课程，修改课程status状态")
    @PostMapping("/publishCourse/{id}")
    public R publisCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    @ApiOperation("根据ID删除课程")
    @DeleteMapping("/deleteCourse/{id}")
    public R deleteCourseById(@PathVariable String id){
        boolean b = eduCourseService.removeById(id);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

