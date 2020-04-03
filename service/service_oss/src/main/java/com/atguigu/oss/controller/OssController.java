package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName Oss
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 9:45 上午
 * @Version 1.0
 */

@RestController
@CrossOrigin
@RequestMapping("/eduoss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public R uploadOssFile(MultipartFile file){
        //  返回上传路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

    //https://edu-guli1010.oss-cn-shanghai.aliyuncs.com/oqStl2L5oxI.jpg
    //https://edu-guli1010oss-cn-shanghai.aliyuncs.com/oqStl2L5oxI.jpg

}
