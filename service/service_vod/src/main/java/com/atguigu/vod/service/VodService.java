package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName vodService
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 2:09 下午
 * @Version 1.0
 */

public interface VodService {

    String uploadVideo(MultipartFile file);

    void deleteVideo(String fileId);
}
