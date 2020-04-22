package com.blog.service;

import com.blog.po.Comment;

import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
public interface CommentService {

    List<Comment> findCommentsByBlogId(Integer blogId);

    void saveComment(Comment comment);
}
