package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.config.exception.CustomException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-07
 */
@Api(value = "小节Controller",tags = {"小节Controller"})
@RestController
@CrossOrigin
@RequestMapping("/eduservice/video")
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private VodClient vodClient;

    @ApiOperation("添加小节")
    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    @ApiOperation("根据ID获取小节信息")
    @GetMapping("/getVideoInfo/{videoId}")
    public R getVideoInfo(@PathVariable String videoId){
        EduVideo video = videoService.getById(videoId);
        return R.ok().data("video",video);
    }

    @ApiOperation("修改小节")
    @PostMapping("/updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        videoService.updateById(eduVideo);
        return R.ok();
    }

    @ApiOperation("删除小节")
    @DeleteMapping("/deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable String videoId){
        EduVideo video = videoService.getById(videoId);
        String sourceId = video.getVideoSourceId();
        if (!StringUtils.isEmpty(sourceId)){
            R delete = vodClient.delete(video.getVideoSourceId());
            if (delete.getCode() == 20001){
                throw new CustomException(20001,"删除视频失败，熔断器生效...");
            }
        }
        videoService.removeById(videoId);
        return R.ok();
    }

}

