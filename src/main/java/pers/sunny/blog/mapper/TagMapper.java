package pers.sunny.blog.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 标签数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select * from tag where deleted = 0 order by tag_blogs desc limit 0,#{size}")
    List<Tag> listLimitTag(Integer size);

    void updateTagBlogsByTagIds(Long id);

    @Select("select id from tag where deleted = 0")
    List<Long> getTagIds();

    @Select("select * from tag where deleted = 0 order by tag_blogs desc")
    List<Tag> listOrderTags();
}
