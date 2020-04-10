package com.atguigu.eduservice.client.impl;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName VodClientImpl
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 5:28 下午
 * @Version 1.0
 */

public class VodClientImpl implements VodClient {
    @Override
    public R upload(MultipartFile file) {
        return R.error().message("上传出错");
    }

    @Override
    public R delete(String id) {
        return R.error().message("删除出错");
    }
}
