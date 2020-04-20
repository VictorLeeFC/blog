package com.blog.service;

import com.blog.po.User;

/**
 * Created on 2020/4/4
 * Package com.blog.service
 *
 * @author dsy
 */
public interface UserService {
    User checkUser(String username,String password);
}
