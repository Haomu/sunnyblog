package pers.sunny.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.sunny.blog.vo.BlogQuery;
import pers.sunny.blog.vo.FirstPageBlog;
import pers.sunny.blog.vo.RecommendBlog;

import java.util.List;

/**
 * <p>
 * 博客数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * @Author Sunny
     * @Description  博客管理专用查询器
     * @Date 2020/8/6
     * @Param [userWrapper]
     * @return java.util.List<pers.sunny.blog.vo.BlogQuery>
     **/
    List<BlogQuery> findAll(@Param(Constants.WRAPPER) Wrapper<BlogQuery> userWrapper);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog(Integer size);

    List<FirstPageBlog> selectListByQuery(@Param(Constants.WRAPPER) QueryWrapper<FirstPageBlog> wrapper);

    /**
     * @Author Sunny
     * @Description  根据typeId查询博客内容
     * @Date 2020/8/10
     * @Param [wrapper]
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    List<FirstPageBlog> listBlogsByTypeId(Long typeId);

    /**
     * @Author Sunny
     * @Description  根据tagId查询博客内容
     * @Date 2020/8/11
     * @Param [tagId]
     * @return java.util.List<pers.sunny.blog.vo.FirstPageBlog>
     **/
    List<FirstPageBlog> listBlogsByTagId(Long tagId);

    @Select("select date_format(update_time,'%Y') year from blog where " +
            "deleted = 0 and published = 1 group by year order by year desc")
    List<String> findYearGroup();

    @Select("select * from blog where date_format(update_time,'%Y') = #{year} and deleted = 0 and published = 1")
    List<Blog> listBlogsByYear(String year);

    @Update("update blog set views = views + 1 where id = #{id} and published = 1 and deleted = 0")
    void updateViews(Long id);
}
