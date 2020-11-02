package pers.sunny.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.sunny.blog.entity.Comment;
import pers.sunny.blog.mapper.CommentMapper;
import pers.sunny.blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 评论数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //先找出父评论
        List<Comment> comments = commentMapper.listCommentByBlogIdAndParentCommentId(blogId, -1L);
        for(Comment comment : comments){
            //父评论id
            Long id = comment.getId();
            //父评论名
            String parentNickname1 = comment.getNickname();
            //根据父评论id找子评论
            List<Comment> childComments = commentMapper.listCommentByBlogIdAndParentCommentId(blogId,id);
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    /**
     * @Author Sunny
     * @Description  被迭代的对象
     * @Date 2020/8/16
     * @Param [comment]
     * @return void
     **/
    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.listCommentByBlogIdAndParentCommentId(blogId,childId);
        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }


    @Override
    public Integer saveComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentMapper.deleteById(id);
    }
}
