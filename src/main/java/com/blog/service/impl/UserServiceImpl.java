package com.blog.service.impl;

import com.blog.mapper.UserMapper;
import com.blog.po.User;
import com.blog.service.UserService;
import com.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        String pwd = MD5Util.md5(password);
        return userMapper.selectUserNameByNameAndPassWord(username,pwd);
    }
}
