package pers.sunny.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.sunny.blog.entity.Tag;
import pers.sunny.blog.service.impl.BlogServiceImpl;
import pers.sunny.blog.service.impl.TagServiceImpl;
import pers.sunny.blog.vo.FirstPageBlog;

import java.util.List;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-11-14:59
 */
@Controller
@RequestMapping("/sunnyblog")
public class TagShowController {
    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/tags/{id}")
    public String types(@PathVariable Long id,
                        @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        List<Tag> tags = tagService.listOrderTags();
        if (id == -1){
            id = tags.get(0).getId();
        }
        PageHelper.startPage(pageNum,6);
        List<FirstPageBlog> blogs = blogService.listBlogsByTagId(id);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);

        model.addAttribute("tags",tags);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTagId",id);
        return "tags";
    }

}
