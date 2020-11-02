package pers.sunny.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.sunny.blog.entity.Blog;
import pers.sunny.blog.entity.Comment;
import pers.sunny.blog.entity.User;
import pers.sunny.blog.service.impl.*;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-15-16:57
 */
@Controller
@RequestMapping("/sunnyblog")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        Blog blog = blogService.getBlogAndConvert(blogId);
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        model.addAttribute("blog",blog);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar("https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg");
        }
        commentService.saveComment(comment);
        return "redirect:/sunnyblog/comments/" + blogId;
    }

    @GetMapping("/comments/{blogId}/{commentId}/delete")
    public String delete(@PathVariable Long blogId,@PathVariable Long commentId,Model model){
        commentService.deleteComment(commentId);
        Blog blog = blogService.getBlogAndConvert(blogId);
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        model.addAttribute("blog",blog);
        return "redirect:/sunnyblog/"+blogId;
    }
}
