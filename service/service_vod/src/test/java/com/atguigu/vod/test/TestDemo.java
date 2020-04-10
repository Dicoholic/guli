package com.atguigu.vod.test;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;
import com.sun.tools.corba.se.idl.ExceptionEntry;

import java.util.List;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 10:58 上午
 * @Version 1.0
 */

public class TestDemo {

    public static void main(String[] args) throws ClientException {
    }

    //删除音视频
    private static void deleteVideo() throws ClientException {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4Fvernm36k3qfFA9un7c", "jJCFEBq0uzrPDzdT9NCYyLVBBdEs77");
        DeleteVideoRequest request = new DeleteVideoRequest();
        request.setVideoIds("5eaf9975c84d466bb01f4a8b535a312d");
        DeleteVideoResponse response = new DeleteVideoResponse();
        response = client.getAcsResponse(request);
        System.out.println("RequestId = "+response.getRequestId());
    }

    //本地上传音视频
    private static void uploadVideo() {
        String accessKeyId = "LTAI4Fvernm36k3qfFA9un7c";
        String accessKeySecret = "jJCFEBq0uzrPDzdT9NCYyLVBBdEs77";
        //文件名称
        String title = "test 01";
        //本地文件路径和名称
        String fileName = "/Users/dicoholic/Downloads/项目资料/1-阿里云上传测试视频/6 - What If I Want to Move Faster.mp4";

        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
        request.setPartSize(2 * 1024 * 1024L);
        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
        request.setTaskNum(1);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }

    //获取视频播放凭证
    public static void getPlayAuth() throws ClientException{
        //初始化
        DefaultAcsClient client = InitObject.initVodClient("LTAI4Fvernm36k3qfFA9un7c", "jJCFEBq0uzrPDzdT9NCYyLVBBdEs77");
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        request.setVideoId("e5f0be482d6a420cbce2c85aaa50b15b");
        response = client.getAcsResponse(request);

        System.out.println("PlayAuth = "+response.getPlayAuth());
        System.out.println("Title = "+response.getVideoMeta().getTitle());
    }

    //获取视频播放地址
    public static void getPlayURL()throws ClientException{
        //初始化
        DefaultAcsClient client = InitObject.initVodClient("LTAI4Fvernm36k3qfFA9un7c", "jJCFEBq0uzrPDzdT9NCYyLVBBdEs77");
        //创建获取视频地址request和response
        GetPlayInfoRequest req = new GetPlayInfoRequest();
        //设置要获取的视频的ID
        req.setVideoId("e5f0be482d6a420cbce2c85aaa50b15b");
        GetPlayInfoResponse response = client.getAcsResponse(req);
        try {
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.println("PalyURL = "+playInfo.getPlayURL());
            }
            System.out.println("Title = "+response.getVideoBase().getTitle());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
