package com.blog.service;

import com.blog.modelEntity.TagTops;
import com.blog.po.Tag;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTagByTagName(String name);

    Tag getTagById(Integer id);

    Page<Tag> getTagByPage();

    int deleteTagById(Integer id);

    Tag updateTag(Tag tag);

    List<Tag> finaAllTags();

    List<Tag> listTag(String ids);

    List<TagTops> findSeveralTopTags(int number);

    List<Tag> findTagsByBlogId(Integer blogId);

    Integer findCount();
}
