package pers.sunny.blog.service;

import pers.sunny.blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.sunny.blog.vo.BlogQuery;
import pers.sunny.blog.vo.FirstPageBlog;
import pers.sunny.blog.vo.RecommendBlog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface BlogService extends IService<Blog> {

    Blog getBlog(Long id);

    List<BlogQuery> listBlogs(BlogQuery blog);

    void deleteBlog(Long id);

    Integer saveBlog(Blog blog);

    List<Blog> listBlogs();

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog(Integer size);

    List<FirstPageBlog> listBlogsByQuery(String query);

    Blog getBlogAndConvert(Long id);

    List<FirstPageBlog> listBlogsByTypeId(Long typeId);

    List<FirstPageBlog> listBlogsByTagId(Long tagId);

    Map<String, List<Blog>> archiveBlog();

    Integer countBlog();
}
