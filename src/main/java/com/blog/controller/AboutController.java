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

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }
}
