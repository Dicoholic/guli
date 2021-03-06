package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.vo.OneSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-02
 */
public interface EduSubjectService extends IService<EduSubject> {

    void addSubject(MultipartFile file, EduSubjectService eduSubjectService);

    List<OneSubject> getAllSubject();
}
