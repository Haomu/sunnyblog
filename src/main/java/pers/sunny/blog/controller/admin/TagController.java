package pers.sunny.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pers.sunny.blog.entity.Tag;
import pers.sunny.blog.service.impl.TagServiceImpl;

import java.util.List;


/**
 * <p>
 * 标签数据表 前端控制器
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Controller
@RequestMapping("/manage")
public class TagController {
    @Autowired
    private TagServiceImpl tagService;

    @RequestMapping("/tags")
    public ModelAndView tags(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tags = tagService.listTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/tags");
        return mv;
    }

    @RequestMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags_input";
    }

    /**
     * @Author Sunny
     * @Description  新增tag
     * @Date 2020/8/9
     * @Param [tag, result, attributes]
     * @return java.lang.String
     **/
    @PostMapping("/tags")
    public String post(Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","该标签已存在，不能重复添加");
        }
        if (result.hasErrors()){
            return "admin/tags_input";
        }

        boolean res = tagService.saveOrUpdate(tag);
        if (!res){
            attributes.addFlashAttribute("message","操作失败");
        } else {
            attributes.addFlashAttribute("message","操作成功");
        }

        return "redirect:/manage/tags";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags_input";
    }

    @RequestMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/manage/tags";
    }

}

