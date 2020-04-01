package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName EduLoginController
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/1 5:04 下午
 * @Version 1.0
 */
@RestController
//解决跨域问题
@CrossOrigin
@RequestMapping("/eduservice/user")
public class EduLoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://pic3.zhimg.com/v2-308ad02297d18f49b5d6fc17be1069b3_r.jpg");
    }

}
