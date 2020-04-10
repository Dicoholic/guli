package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.eduservice.vo.ChapterVo;
import com.atguigu.eduservice.vo.VideoVo;
import com.atguigu.servicebase.config.exception.CustomException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author dicoholic
 * @since 2020-04-07
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        //1.根据课程id查询课程里面的所有章节
        QueryWrapper wrapperChapter = new QueryWrapper();
        wrapperChapter.eq("course_id",courseId);
        wrapperChapter.orderByAsc("gmt_create");
        List<EduChapter> chapterList = baseMapper.selectList(wrapperChapter);
        //2.根据课程id查询课程里面的所有小节
        QueryWrapper wrapperVideo = new QueryWrapper();
        wrapperVideo.eq("course_id",courseId);
        List<EduVideo> videoList = videoService.list(wrapperVideo);

        List<ChapterVo> list = new ArrayList<>();

        for (int i = 0; i < chapterList.size(); i++) {
            ChapterVo chapterVo = new ChapterVo();
            EduChapter eduChapter = chapterList.get(i);
            BeanUtils.copyProperties(eduChapter,chapterVo);
            List<VideoVo> voList = new ArrayList<>();
            for (int j = 0; j < videoList.size(); j++) {
                if (videoList.get(j).getChapterId().equals(chapterVo.getId())){
                    VideoVo videoVo = new VideoVo();
                    EduVideo eduVideo = videoList.get(j);
                    BeanUtils.copyProperties(eduVideo,videoVo);
                    voList.add(videoVo);
                }
            }
            chapterVo.setChildren(voList);
            list.add(chapterVo);
        }

        return list;
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("chapter_id",chapterId);
        //一起删除
//        List<EduVideo> videoList = videoService.list(wrapper);
//        if (videoList.size()!=0 && videoList != null){
//            for (int i = 0; i < videoList.size(); i++) {
//                videoService.removeById(videoList.get(i).getId());
//            }
//        }
        int count = videoService.count(wrapper);
        if (count>0){
            throw new CustomException(20001,"章节中还有其他内容");
        }else{
            int result =baseMapper.deleteById(chapterId);
            return result>0;
        }
    }
}
