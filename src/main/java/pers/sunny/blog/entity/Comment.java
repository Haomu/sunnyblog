package pers.sunny.blog.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 评论时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 父评论id
     */
    private Long parentCommentId;

    /**
     * 父评论昵称
     */
    @TableField(exist = false)
    private String parentNickname;

    /**
     * 是否为博主评论
     */
    private Boolean adminComment;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    /**
     * 一条父评论对应一个回复评论的集合
     */
    @TableField(exist = false)
    private List<Comment> replyComments = new ArrayList<>();

}
