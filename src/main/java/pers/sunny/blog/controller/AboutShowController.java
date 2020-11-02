package pers.sunny.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-12-16:19
 */
@Controller
@RequestMapping("/sunnyblog")
public class AboutShowController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
