package com.blog.controller.admin;

import com.blog.po.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-02
 * @author: li
 * @version: v0.1
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String loginPage(Model model){

        return "admin/login";
    }

    @PostMapping(value = "login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes)
    {
        //获得用户信息
        User admin = userService.checkUser(username, password);

        if (admin!=null){
            admin.setPassword(null);
            session.setAttribute("user",admin);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:admin";
        }
    }


    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:admin";
    }

}
