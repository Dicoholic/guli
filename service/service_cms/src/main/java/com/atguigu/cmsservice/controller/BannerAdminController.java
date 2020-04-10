package com.atguigu.cmsservice.controller;


import com.atguigu.cmsservice.entity.CrmBanner;
import com.atguigu.cmsservice.service.CrmBannerService;
import com.atguigu.commonutils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-10
 */
@RestController
@CrossOrigin
@RequestMapping("/cmsservice/banneradmin")
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;

    @ApiOperation(value = "获取Banner分页列表")
    @GetMapping("/pageBanner/{page}/{limit}")
    public R index(@PathVariable("page") Long page,
                   @PathVariable("limit") Long limit){
        Page<CrmBanner> pageParam = new Page<>(page,limit);
        bannerService.page(pageParam,null);
        return R.ok().data("items",pageParam.getRecords()).data("total",pageParam.getTotal());
    }

    @ApiOperation(value = "获取Banner")
    @GetMapping("/getBanner/{id}")
    public R getBanner(@PathVariable String id){
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("item",banner);
    }

    @ApiOperation(value = "新增Banner")
    @PostMapping("/addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner){
        bannerService.save(crmBanner);
        return R.ok();
    }

    @ApiOperation(value = "修改Banner")
    @PostMapping("/updateBanner")
    public R updateBanner(@RequestBody CrmBanner crmBanner){
        bannerService.updateById(crmBanner);
        return R.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("/deleteBanner/{id}")
    public R delete(@PathVariable String id){
        bannerService.removeById(id);
        return R.ok();
    }

}

