package com.blog.service;

import com.blog.po.Blog;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
public interface BlogService {

    Blog findBlogByBlogId(Integer id);

    Blog addBlog(Blog blog);

    List<Blog> findAllBlogByPage();

    Integer deleteBlog(Integer id);

    Page<Blog> selectBlogByKeyWords(String title, String typeId, String recommend);

    String findTagsByBlogId(Integer blogId);

    List<Blog> findTheLastBlog(int i);

    Page<Blog> findBlogByKeyWords(String key);

    List<Blog> findBlogByTypeId(Integer typeId);

    List<Blog> findBlogByTagId(Integer tagId);

    Map<String, List<Blog>> findArchiveBlog();

    Integer findBlogCount();

    void addBlogViews(Blog blog);
}
