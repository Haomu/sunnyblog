package pers.sunny.blog.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.sunny.blog.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-05-14:38
 */
@Controller
@RequestMapping("/manage")
public class LoginController {

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装登录的用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            Subject curSubject = SecurityUtils.getSubject();
            curSubject.getSession().setAttribute("user",curSubject.getPrincipal());
            return "redirect:/manage/success";
        } catch (UnknownAccountException e) {
            model.addAttribute("message","用户名错误");
            return "admin/login";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "admin/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/manage/toLogin";
    }

    @RequestMapping("/toAdmin")
    public String admin(){
        return "admin/blog_manage";
    }

    @RequestMapping("/publish")
    public String publish(){
        return "admin/blog_published";
    }

    @RequestMapping("/success")
    public String welcome(){
        return "admin/welcome";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "admin/login";
    }
}
