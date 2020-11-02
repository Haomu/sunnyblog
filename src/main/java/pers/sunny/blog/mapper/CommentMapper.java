package pers.sunny.blog.mapper;

import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 评论数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> listCommentByBlogIdAndParentCommentId(Long blogId, Long id);
}
