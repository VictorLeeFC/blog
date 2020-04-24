package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-03
 * @author: li
 * @version: v0.1
 */
@Controller
public class AboutController {
    /** 关于我 */
    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }
    /** 简历 */
    @GetMapping(value = "/about/resume")
    public String resume(){
        return "resume";
    }
}
