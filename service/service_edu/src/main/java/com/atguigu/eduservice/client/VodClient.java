package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.impl.VodClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName VodClient
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 4:59 下午
 * @Version 1.0
 */
@Component
@FeignClient(value = "service-vod",fallback = VodClientImpl.class)
public interface VodClient {

    @PostMapping("/upload")
    public R upload(MultipartFile file);

    @DeleteMapping("/eduvod/filevod/detele/{id}")
    public R delete(@PathVariable("id") String id);
}
