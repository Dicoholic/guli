package com.atguigu.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConstantPropertiesUtils
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/9 2:02 下午
 * @Version 1.0
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value(value = "${aliyun.vod.file.regionid}")
    private String regionId;

    @Value(value = "${aliyun.vod.file.keyid}")
    private String keyid;

    @Value(value = "${aliyun.vod.file.keysecret}")
    private String keysecret;

    public static String REGION_ID;

    public static String KEY_ID;

    public static String KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        REGION_ID = regionId;
        KEY_ID = keyid;
        KEY_SECRET = keysecret;
        System.out.println(REGION_ID+"*****************"+KEY_ID+"*****************"+KEY_SECRET);
    }
}
