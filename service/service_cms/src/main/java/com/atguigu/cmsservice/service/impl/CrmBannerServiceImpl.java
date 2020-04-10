package com.atguigu.cmsservice.service.impl;

import com.atguigu.cmsservice.entity.CrmBanner;
import com.atguigu.cmsservice.mapper.CrmBannerMapper;
import com.atguigu.cmsservice.service.CrmBannerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-10
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Override
    public List<CrmBanner> selectAllBanner() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("id");
        wrapper.last(" limit 2 ");
        List<CrmBanner> crmBanners = baseMapper.selectList(wrapper);
        return crmBanners;
    }
}
