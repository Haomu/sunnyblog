package pers.sunny.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description 博客首页数据实体类
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-09-21:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private Long typeId;
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}
