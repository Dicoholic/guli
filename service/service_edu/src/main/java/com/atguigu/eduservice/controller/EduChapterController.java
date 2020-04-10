package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.vo.ChapterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "章节Controller",tags = {"章节Controller"})
@RestController
@CrossOrigin
@RequestMapping("/eduservice/chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @ApiOperation("根据课程ID获取所有章节")
    @GetMapping("/getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list = eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("list",list);
    }

    @ApiOperation("添加章节")
    @PostMapping("/addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return R.ok();
    }

    @ApiOperation("根据ID获取章节信息")
    @GetMapping("/getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){
        EduChapter chapterInfo = eduChapterService.getById(chapterId);
        return R.ok().data("chapterInfo",chapterInfo);
    }

    @ApiOperation("更新章节")
    @PostMapping("/updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return R.ok();
    }

    @ApiOperation("根据章节ID删除章节")
    @DeleteMapping("/deleteChapter/{chapterId}")
    public R updateChapter(@PathVariable String chapterId){
        boolean flag = eduChapterService.deleteChapter(chapterId);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }


}

