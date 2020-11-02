package pers.sunny.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.sunny.blog.entity.*;
import pers.sunny.blog.service.impl.*;
import pers.sunny.blog.vo.FirstPageBlog;
import pers.sunny.blog.vo.RecommendBlog;

import java.util.List;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-02-17:43
 */
@Controller
@RequestMapping("/sunnyblog")
public class IndexController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private TypeServiceImpl typeService;

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/")
    public String index(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,6);

        List<FirstPageBlog> blogs = blogService.getAllFirstPageBlog();  //前台博客列表展示
        List<RecommendBlog> recommendedBlogs = blogService.getRecommendedBlog(8);  //推荐博客

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);

        List<Tag> tags = tagService.listLimitTag(10);  //返回10条tag
        List<Type> types = typeService.listLimitType(5);  //返回5条type

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        model.addAttribute("recommendedBlogs",recommendedBlogs);
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(name = "query") String query,Model model){
        PageHelper.startPage(pageNum,6);
        List<FirstPageBlog> blogs = blogService.listBlogsByQuery(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);

        return "search";
    }

    @GetMapping("/{id}")
    public String blog(@PathVariable Long id,Model model){
        Blog blog = blogService.getBlogAndConvert(id);
        model.addAttribute("comments",commentService.listCommentByBlogId(id));
        model.addAttribute("blog",blog);
        return "blog";
    }

}
