package com.atguigu.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.atguigu.servicebase.config.exception.CustomException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.AliyunVodSDKUtils;
import com.atguigu.vod.utils.ConstantPropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @ClassName VodServiceImpl
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 2:09 下午
 * @Version 1.0
 */
@Service
@Slf4j
public class VodServiceImpl implements VodService {

    @Override
    public String uploadVideo(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String title = originalFilename.substring(0,originalFilename.lastIndexOf("."));
            UploadStreamRequest request = new UploadStreamRequest(
                    ConstantPropertiesUtils.KEY_ID,
                    ConstantPropertiesUtils.KEY_SECRET,
                    title,originalFilename,inputStream
            );
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = response.getVideoId();
            if (!response.isSuccess()){
                String errorMessage = "阿里云上传错误:"+"code:"+response.getCode()+",message:"+response.getMessage();
                log.warn(errorMessage);
                if (StringUtils.isEmpty(videoId)){
                    throw new CustomException(20001,errorMessage);
                }
            }
            return videoId;
        }catch (Exception e){
            throw new CustomException(20001,"服务上传失败");
        }
    }

    @Override
    public void deleteVideo(String fileId) {
//        DefaultAcsClient client = InitObject.initVodClient("LTAI4Fvernm36k3qfFA9un7c", "jJCFEBq0uzrPDzdT9NCYyLVBBdEs77");
//        DeleteVideoRequest request = new DeleteVideoRequest();
//        request.setVideoIds("5eaf9975c84d466bb01f4a8b535a312d");
//        DeleteVideoResponse response = new DeleteVideoResponse();
//        response = client.getAcsResponse(request);
//        System.out.println("RequestId = "+response.getRequestId());
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtils.KEY_ID,ConstantPropertiesUtils.KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            DeleteVideoResponse response = new DeleteVideoResponse();
            request.setVideoIds(fileId);
            response = client.getAcsResponse(request);
        }catch (Exception e){
            throw new CustomException(20001,"视频删除失败");
        }
    }
}
