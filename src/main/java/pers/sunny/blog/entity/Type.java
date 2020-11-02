package pers.sunny.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 博文分类数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Type implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 分类类名
     */
    private String name;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    /**
     * 某个type对应的博客数量
     */
    private Integer typeBlogs;
}
