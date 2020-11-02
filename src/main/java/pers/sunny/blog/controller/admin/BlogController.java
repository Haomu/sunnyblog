package pers.sunny.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pers.sunny.blog.entity.*;
import pers.sunny.blog.service.impl.BlogServiceImpl;
import pers.sunny.blog.service.impl.TagServiceImpl;
import pers.sunny.blog.service.impl.TypeServiceImpl;
import pers.sunny.blog.vo.BlogQuery;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * <p>
 * 博客数据表 前端控制器
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Controller
@RequestMapping("/manage")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private TypeServiceImpl typeService;
    @Autowired
    private TagServiceImpl tagService;

    /**
     * @Author Sunny
     * @Description  博客管理首页列表展示
     * @Date 2020/8/9
     * @Param [pageNum, pageSize, blog, model]
     * @return java.lang.String
     **/
    @GetMapping("/blogs")
    public String blogs(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                        BlogQuery blog, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<BlogQuery> blogs = blogService.listBlogs(blog);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",typeService.listTypes());

        return "admin/blog_manage";
    }

    /**
     * @Author Sunny
     * @Description  博客管理搜索功能
     * @Date 2020/8/9
     * @Param [pageNum, pageSize, blog, model]
     * @return java.lang.String
     **/
    @RequestMapping("/blogs/search")
    public String search(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                         BlogQuery blog, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<BlogQuery> blogs = blogService.listBlogs(blog);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/blog_manage :: blogList";
    }

    /**
     * @Author Sunny
     * @Description  初始化新增页面
     * @Date 2020/8/9
     * @Param [model]
     * @return java.lang.String
     **/
    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.listTypes());
        model.addAttribute("tags",tagService.listTags());
        model.addAttribute("blog",new Blog());
        return "admin/blog_published";
    }

    /**
     * @Author Sunny
     * @Description  新增/更新文章
     * @Date 2020/8/9
     * @Param [blog, attributes, session]
     * @return java.lang.String
     **/
    @PostMapping("/blogs")
    public String input(Blog blog, RedirectAttributes attributes, HttpSession session){

        //设置User
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getId());
        blog.init();
        if (blog.getViews() == null){
            blog.setViews(0);
        }

        blog.setType(typeService.getType(blog.getTypeId()));

        blog.setTags(tagService.listTag(blog.getTagIds()));

        boolean res = blogService.saveOrUpdate(blog);

        typeService.updateTagBlogsByTypeIds();  //更新typeBlogs数量
        tagService.updateTagBlogsByTagIds();  //更新tagBlogs数量

        if (!res){
            attributes.addFlashAttribute("message","操作失败");
        } else {
            attributes.addFlashAttribute("message","操作成功");
        }

        return "redirect:/manage/blogs";
    }

    /**
     * @Author Sunny
     * @Description  编辑文章
     * @Date 2020/8/9
     * @Param [id, model]
     * @return java.lang.String
     **/
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        Blog blog = blogService.getBlog(id);
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.init();

        model.addAttribute("blog",blog);

        List<Type> types = typeService.listTypes();
        model.addAttribute("types",types);
        List<Tag> tags = tagService.listTags();
        model.addAttribute("tags",tags);
        return "admin/blog_published";
    }
    /**
     * @Author Sunny
     * @Description  删除文章
     * @Date 2020/8/9
     * @Param
     * @return
     **/
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        typeService.updateTagBlogsByTypeIds();  //更新typeBlogs数量
        tagService.updateTagBlogsByTagIds();  //更新tagBlogs数量
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/manage/blogs";
    }
}

