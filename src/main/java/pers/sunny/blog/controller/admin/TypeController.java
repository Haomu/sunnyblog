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
import pers.sunny.blog.entity.Type;
import pers.sunny.blog.service.impl.TypeServiceImpl;

import java.util.List;


/**
 * <p>
 * 博文分类数据表 前端控制器
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Controller
@RequestMapping("/manage")
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping("/types")
    public ModelAndView types(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Type> types = typeService.listTypes();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/types");
        return mv;
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types_input";
    }

    @PostMapping("/types")
    public String post(Type type, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","该分类已存在，不能重复添加");
        }
        if (result.hasErrors()){
            return "admin/types_input";
        }

        boolean res = typeService.saveOrUpdate(type);
        if (!res){
            attributes.addFlashAttribute("message","操作失败");
        } else {
            attributes.addFlashAttribute("message","操作成功");
        }

        return "redirect:/manage/types";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types_input";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/manage/types";
    }

}

