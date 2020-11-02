package pers.sunny.blog.vo;

import lombok.Data;
import pers.sunny.blog.entity.Type;

import java.util.Date;

/**
 * @Description 后台博客文章查询实体
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-06-20:03
 */
@Data
public class BlogQuery {

    private Long id;
    private String title;
    private Date updateTime;
    private boolean recommend = true;
    private boolean published;
    private Long typeId;
    private Type type;


}
