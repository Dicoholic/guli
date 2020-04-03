package com.atguigu.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConstantPropertiesUtils
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/2 9:37 上午
 * @Version 1.0
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //  读取属性
    @Value(value = "${aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value(value = "${aliyun.oss.file.keyid}")
    private String keyid;

    @Value(value = "${aliyun.oss.file.keysecret}")
    private String keysecret;

    @Value(value = "${aliyun.oss.file.bucketname}")
    private String bucketname;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyid;
        KEY_SECRET = keysecret;
        BUCKET_NAME = bucketname;
    }
}
