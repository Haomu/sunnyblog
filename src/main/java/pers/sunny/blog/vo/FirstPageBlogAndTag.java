package pers.sunny.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-11-15:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FirstPageBlogAndTag {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String tagName;

    //User
    private String nickname;
    private String avatar;
}
