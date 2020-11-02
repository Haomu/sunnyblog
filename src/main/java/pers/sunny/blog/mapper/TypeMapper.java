package pers.sunny.blog.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 博文分类数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface TypeMapper extends BaseMapper<Type> {

    @Select("select * from type where deleted = 0 order by type_blogs desc limit 0,#{size}")
    List<Type> listLimitType(Integer size);

    @Update("update type set type_blogs+=1 where id = #{typeId} and published")
    void increaseBlogNumsByTypeId(Long typeId);

    @Update("update type set type_blogs-=1 where id = #{typeId} ")
    void decreaseBlogNumsByTypeId(Long typeId);

    @Select("select * from type where deleted = 0 order by type_blogs desc")
    List<Type> listOrderTypes();

    /**
     * @Author Sunny
     * @Description  更新Type对应博客数量
     * @Date 2020/8/10
     * @Param [typeId]
     * @return void
     **/
    void updateTagBlogsByTypeIds(Long typeId);

    @Select("select id from type where deleted = 0")
    List<Long> listTypeIds();
}
