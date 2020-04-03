package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OssService
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 9:45 上午
 * @Version 1.0
 */

public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
