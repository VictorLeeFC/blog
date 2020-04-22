package com.blog.controller;

import com.blog.po.Blog;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-10
 * @author: li
 * @version: v0.1
 */
@Controller
public class ArchivesController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/archives")
    public String archives(Model model) {
        Map<String, List<Blog>> map = blogService.findArchiveBlog();
        model.addAttribute("map", map);
        model.addAttribute("count", blogService.findBlogCount());
        return "archives";
    }

}
