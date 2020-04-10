package com.atguigu.cmsservice.controller;

import com.atguigu.cmsservice.entity.CrmBanner;
import com.atguigu.cmsservice.service.CrmBannerService;
import com.atguigu.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BannerFrontController
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/10 2:49 下午
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/cmsservice/bannerfront")
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;

    @ApiOperation("获取所有Banner")
    @GetMapping("/getAllBanner")
    public R getAll(){
        List<CrmBanner> items = bannerService.selectAllBanner();
        return R.ok().data("items",items);
    }

}
