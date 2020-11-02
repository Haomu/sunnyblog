package pers.sunny.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.sunny.blog.entity.Type;
import pers.sunny.blog.service.impl.BlogServiceImpl;
import pers.sunny.blog.service.impl.TypeServiceImpl;
import pers.sunny.blog.vo.FirstPageBlog;

import java.util.List;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-10-16:44
 */
@Controller
@RequestMapping("/sunnyblog")
public class TypeShowController {

    @Autowired
    private TypeServiceImpl typeService;

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/types/{id}")
    public String types(@PathVariable Long id,
                        @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        List<Type> types = typeService.listOrderTypes();
        if (id == -1){
            id = types.get(0).getId();
        }
        PageHelper.startPage(pageNum,6);
        List<FirstPageBlog> blogs = blogService.listBlogsByTypeId(id);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);

        model.addAttribute("types",types);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeId",id);
        return "types";
    }
}
