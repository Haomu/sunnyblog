package pers.sunny.blog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.sunny.blog.entity.Blog;
import pers.sunny.blog.entity.Comment;
import pers.sunny.blog.entity.Message;
import pers.sunny.blog.entity.User;
import pers.sunny.blog.service.impl.BlogServiceImpl;
import pers.sunny.blog.service.impl.MessageServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 留言数据表 前端控制器
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Controller
@RequestMapping("/sunnyblog")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("/test")
    public String toMessage(){
        return "messages";
    }

    @GetMapping("/messages")
    public String messages(Model model,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Message> messages = messageService.listMessage();
        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        model.addAttribute("pageInfo", pageInfo);
        return "messages";
    }

    @RequestMapping("/addMessages")
    public String post(Message message, HttpSession session,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,Model model){
        PageHelper.startPage(pageNum,6);
        User user = (User) session.getAttribute("user");
        if (user != null){
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {
            message.setAvatar("https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg");
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessage();
        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        model.addAttribute("pageInfo", pageInfo);
        return "messages::messageList";
    }

    @GetMapping("/messages/{messageId}/delete")
    public String delete(@PathVariable Long messageId, Model model){
        messageService.deleteMessage(messageId);
        model.addAttribute("messages",messageService.listMessage());
        return "redirect:/sunnyblog/messages";
    }

}

