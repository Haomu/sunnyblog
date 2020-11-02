package pers.sunny.blog.service;

import pers.sunny.blog.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 博文分类数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface TypeService extends IService<Type> {

    Type getType(Long id);

    List<Type> listTypes();

    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> listLimitType(Integer size);

    void increaseBlogNumsByTypeId(Long typeId);

    void decreaseBlogNumsByTypeId(Long typeId);


    /**
     * @Author Sunny
     * @Description  查询所有Type，按每个Type对应的博客数量排序
     * @Date 2020/8/10
     * @Param []
     * @return java.util.List<pers.sunny.blog.entity.Type>
     **/
    List<Type> listOrderTypes();

    /**
     * @Author Sunny
     * @Description  更新Type对应的博客数量
     * @Date 2020/8/10
     * @Param []
     * @return void
     **/
    void updateTagBlogsByTypeIds();
}
