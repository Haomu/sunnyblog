package pers.sunny.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 标签数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 标签
     */
    private String name;
    /**
     * 逻辑删除
     */
    private Integer deleted;

    /**
     * 某个tag对应的博客数量
     */
    private Integer tagBlogs;

}
