package com.blog.service;

import com.blog.po.User;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
public interface UserService {
    User checkUser(String username,String password);
}
