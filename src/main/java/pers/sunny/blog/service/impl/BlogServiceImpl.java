package pers.sunny.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.sunny.blog.entity.Blog;
import pers.sunny.blog.utils.MarkdownUtils;
import pers.sunny.blog.vo.BlogQuery;
import pers.sunny.blog.vo.FirstPageBlog;
import pers.sunny.blog.vo.RecommendBlog;
import pers.sunny.blog.mapper.BlogMapper;
import pers.sunny.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private TypeServiceImpl typeService;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.selectById(id);
    }

    /**
     * @Author Sunny
     * @Description  博客管理专用查询器
     * @Date 2020/8/6
     * @Param [blog]
     * @return java.util.List<pers.sunny.blog.vo.BlogQuery>
     **/
    @Override
    public List<BlogQuery> listBlogs(BlogQuery blog) {
        QueryWrapper<BlogQuery> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(blog.getTitle()),"title",blog.getTitle())
                .eq(ObjectUtils.isNotNull(blog.getTypeId()),"type_id",blog.getTypeId())
                .eq("recommend",blog.isRecommend());
        return blogMapper.findAll(wrapper);
    }


    /**
     * @Author Sunny
     * @Description  前台列表展示和详情查询
     * @Date 2020/8/6
     * @Param []
     * @return java.util.List<pers.sunny.blog.entity.Blog>
     **/
    @Override
    public List<Blog> listBlogs() {
        return blogMapper.selectList(null);
    }

    /**
     * @Author Sunny
     * @Description  查询所有的博客首页数据
     * @Date 2020/8/6
     * @Param []
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogMapper.getFirstPageBlog();
    }

    /**
     * @Author Sunny
     * @Description  查询所有的推荐博客数据
     * @Date 2020/8/7
     * @Param []
     * @return java.util.List<pers.sunny.blog.vo.RecommendBlog>
     **/
    @Override
    public List<RecommendBlog> getRecommendedBlog(Integer size) {
        return blogMapper.getAllRecommendBlog(size);
    }

    /**
     * @Author Sunny
     * @Description  全局搜索功能
     * @Date 2020/8/10
     * @Param [query]
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    @Override
    public List<FirstPageBlog> listBlogsByQuery(String query) {
        QueryWrapper<FirstPageBlog> wrapper = new QueryWrapper<>();
        wrapper.like("title",query).or().like("content",query);
        return blogMapper.selectListByQuery(wrapper);
    }

    /**
     * @Author Sunny
     * @Description  Markdown转HTML
     * @Date 2020/8/10
     * @Param [id]
     * @return pers.sunny.blog.entity.Blog
     **/
    @Override
    public Blog getBlogAndConvert(Long id) {
        blogMapper.updateViews(id);
        Blog blog = blogMapper.selectById(id);
        Blog newBlog = new Blog();
        BeanUtils.copyProperties(blog,newBlog);
        String content = newBlog.getContent();
        newBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        newBlog.setType(typeService.getType(newBlog.getTypeId()));  //将查询出来的博客详情的Type放入Blog
        newBlog.setTags(tagService.listTag(newBlog.getTagIds()));  //将查询出来的博客详情的Tag放入Blog
        newBlog.setUser(userService.getById(newBlog.getUserId()));  //将查询出来的博客相关联的用户信息放入Blog

        return newBlog;
    }

    /**
     * @Author Sunny
     * @Description  根据typeId查询博客内容
     * @Date 2020/8/10
     * @Param [id]
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    @Override
    public List<FirstPageBlog> listBlogsByTypeId(Long typeId) {
        return blogMapper.listBlogsByTypeId(typeId);
    }

    /**
     * @Author Sunny
     * @Description  根据tagId查询博客内容
     * @Date 2020/8/11
     * @Param [id]
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    @Override
    public List<FirstPageBlog> listBlogsByTagId(Long tagId) {
        return blogMapper.listBlogsByTagId(tagId);
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogMapper.findYearGroup();
        Map<String, List<Blog>> map = new LinkedHashMap<>();
        for (String year : years) {
            map.put(year,blogMapper.listBlogsByYear(year));
        }
        return map;
    }

    @Override
    public Integer countBlog() {
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.eq("published",1);
        return blogMapper.selectCount(wrapper);
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteById(id);
    }

    @Override
    public Integer saveBlog(Blog blog) {
        return blogMapper.insert(blog);
    }



}
