package com.atguigu.commonutils.utils;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName ExceptionUtil
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/1 1:09 下午
 * @Version 1.0
 */

public class ExceptionUtil {

    public static String getMessage(Exception e){
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        }finally {
            if (sw!=null){
                try {
                    sw.close();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (pw!=null){
                pw.close();
            }
        }
        return sw.toString();
    }
}
