package pers.sunny.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 推荐博客数据实体类
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-09-21:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecommendBlog {
    private Long id;
    private String title;
    private boolean recommend;
}
