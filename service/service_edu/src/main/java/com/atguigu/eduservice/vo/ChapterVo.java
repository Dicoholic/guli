package com.atguigu.eduservice.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChapterVo
 * @Description TODO
 * @Author dicoholic
 * @Date 2020/4/8 9:49 上午
 * @Version 1.0
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> children = new ArrayList<>();

}

