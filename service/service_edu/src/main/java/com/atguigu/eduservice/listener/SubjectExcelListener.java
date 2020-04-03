package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.commonutils.utils.ExceptionUtil;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.eduservice.vo.SubjectData;
import com.atguigu.servicebase.config.exception.CustomException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * @ClassName SubjectExcelListener
 * @Description 不能交给spring进行管理，需要自己new创建，不能注入其他对象
 * @Author dicoholic
 * @Date 2020/4/2 2:35 下午
 * @Version 1.0
 */

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    @Autowired
    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {}

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.eduSubjectService = subjectService;
    }

    /**
     * 读取excel内容
     * @param data
     * @param context
     */
    @Override
    public void invoke(SubjectData data, AnalysisContext context) {
        if (data == null){
            throw new CustomException(20001,"文件数据为空");
        }

        // 一行一行读取，每次读取有两个值，第一个值以及分类，第二个值二级分类
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, data.getOneSubjectName());
        if (existOneSubject == null){
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(data.getOneSubjectName());
            eduSubjectService.save(existOneSubject);
        }

        // 二级分类
        String pid=existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, data.getOneSubjectName(), pid);
        if (existTwoSubject == null){
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(data.getTwoSubjectName());
            eduSubjectService.save(existTwoSubject);
        }
    }

    // 判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject one = eduSubjectService.getOne(wrapper);
        return one;
    }

    // 判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject one = eduSubjectService.getOne(wrapper);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
