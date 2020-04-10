package com.atguigu.vod.controller;

import com.atguigu.commonutils.R;
import com.atguigu.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName vodController
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 2:08 下午
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/eduvod/filevod")
public class VodController {

    @Autowired
    private VodService vodService;


    @PostMapping("/upload")
    public R upload(MultipartFile file){
        String videoId = vodService.uploadVideo(file);
        return R.ok().data("videoId",videoId);
    }

    @DeleteMapping("/detele/{id}")
    public R delete(@PathVariable String id){
        vodService.deleteVideo(id);
        return R.ok();
    }



}
