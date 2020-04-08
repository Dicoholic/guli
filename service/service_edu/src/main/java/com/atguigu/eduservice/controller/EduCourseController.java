package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-07
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    //添加课程基本信息
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){

        // 返回添加之后课程id
        String cid = eduCourseService.saveCourseInfo(courseInfoVo);

        return R.ok().data("cid",cid);
    }


}

