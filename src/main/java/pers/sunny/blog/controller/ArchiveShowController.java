package pers.sunny.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.sunny.blog.entity.Blog;
import pers.sunny.blog.service.impl.BlogServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-12-11:46
 */
@Controller
@RequestMapping("/sunnyblog")
public class ArchiveShowController {
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        Map<String, List<Blog>> archiveBlog = blogService.archiveBlog();
        Integer blogCount = blogService.countBlog();
        model.addAttribute("archiveBlog",archiveBlog);
        model.addAttribute("blogCount",blogCount);
        return "archives";
    }

}
