package pers.sunny.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pers.sunny.blog.entity.Type;
import pers.sunny.blog.mapper.TypeMapper;
import pers.sunny.blog.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博文分类数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Autowired
    private TypeMapper typeMapper;


    @Override
    public Type getType(Long id) {
        return typeMapper.selectById(id);
    }

    @Override
    public List<Type> listTypes() {
        return typeMapper.selectList(null);
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        QueryWrapper<Type> wrapper = new QueryWrapper<>();
        wrapper.select("name").eq("name",name);
        return typeMapper.selectOne(wrapper);
    }

    /**
     * @Author Sunny
     * @Description  前台分类展示
     * @Date 2020/8/3
     * @Param [size] 限制size条
     * @return java.util.List<pers.sunny.blog.entity.Type>
     **/
    @Override
    public List<Type> listLimitType(Integer size) {
        return typeMapper.listLimitType(size);
    }

    /**
     * @Author Sunny
     * @Description  更新type对应博客数量
     * @Date 2020/8/5
     * @Param [typeId]
     * @return void
     **/
    @Override
    public void increaseBlogNumsByTypeId(Long typeId) {
        typeMapper.increaseBlogNumsByTypeId(typeId);
    }

    /**
     * @Author Sunny
     * @Description  更新type对应博客数量
     * @Date 2020/8/5
     * @Param [typeId]
     * @return void
     **/
    @Override
    public void decreaseBlogNumsByTypeId(Long typeId) {
        typeMapper.decreaseBlogNumsByTypeId(typeId);
    }


    /**
     * @Author Sunny
     * @Description  查询所有Type，按每个Type对应的博客数量排序
     * @Date 2020/8/10
     * @Param []
     * @return java.util.List<pers.sunny.blog.entity.Type>
     **/
    @Override
    public List<Type> listOrderTypes() {
        return typeMapper.listOrderTypes();
    }

    /**
     * @return void
     * @Author Sunny
     * @Description 更新Type对应的博客数量
     * @Date 2020/8/10
     **/
    @Override
    public void updateTagBlogsByTypeIds() {
        List<Long> typeIds = typeMapper.listTypeIds();
        for (Long id : typeIds) {
            typeMapper.updateTagBlogsByTypeIds(id);
        }
    }




}
