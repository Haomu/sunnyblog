package pers.sunny.blog.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 博客数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Blog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 赞赏是否开启
     */
    private Boolean appreciation = false;

    /**
     * 评论是否开启
     */
    private Boolean commentabled = false;

    /**
     * 内容
     */
    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 首图
     */
    private String firstPicture;

    /**
     * 标记(转载，原创等等)
     */
    private String flag;

    /**
     * 是否发布
     */
    private Boolean published;

    /**
     * 是否推荐
     */
    private Boolean recommend = false;

    /**
     * 转载声明是否开启
     */
    private Boolean shareStatement = false;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 浏览次数
     */
    private Integer views;

    private Long typeId;

    private Long userId;

    /**
     * 评论次数
     */
    private Integer commentCount;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    private String tagIds;

    @TableField(exist = false)
    private Type type;

    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private List<Comment> comments = new ArrayList<>();

    /**
     * 字符串形式存储多个tagId 1,2,3，...
     */
    @TableField(exist = false)
    private List<Tag> tags = new ArrayList<>();

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }
}
