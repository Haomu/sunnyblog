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
 * 留言数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Message implements Serializable {

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
     * 内容
     */
    private String content;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 父评论id
     */
    private Long parentMessageId;

    /**
     * 父评论昵称
     */
    @TableField(exist = false)
    private String parentNickname;

    /**
     * 是否为管理员消息
     */
    private Boolean adminMessage;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    /**
     * 一条父评论对应一个回复评论的集合
     */
    @TableField(exist = false)
    private List<Message> replyMessages = new ArrayList<>();


}
