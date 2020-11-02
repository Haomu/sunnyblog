package pers.sunny.blog.service;

import pers.sunny.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface CommentService extends IService<Comment> {

    List<Comment> listCommentByBlogId(Long blogId);

    Integer saveComment(Comment comment);

    void deleteComment(Long id);
}
