package pers.sunny.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.sunny.blog.entity.Tag;
import pers.sunny.blog.mapper.TagMapper;
import pers.sunny.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 标签数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag getTag(Long id) {
        return tagMapper.selectById(id);
    }

    @Override
    public List<Tag> listTags() {
        return tagMapper.selectList(null);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.select("name").eq("name",name);
        return tagMapper.selectOne(wrapper);
    }

    @Override
    public List<Tag> listTag(String tagIds) {
        return tagMapper.selectBatchIds(convertToList(tagIds));
    }

    @Override
    public List<Tag> listLimitTag(Integer size) {
        return tagMapper.listLimitTag(size);
    }

    /**
     * @Author Sunny
     * @Description  更新Tag对应的博客数量
     * @Date 2020/8/10
     * @Param []
     * @return void
     **/
    @Override
    public void updateTagBlogsByTagIds() {
        List<Long> ids = getTagIds();
        for (Long id : ids) {
            tagMapper.updateTagBlogsByTagIds(id);
        }
    }

    @Override
    public List<Long> getTagIds() {
        return tagMapper.getTagIds();
    }


    @Override
    public List<Tag> listOrderTags() {
        return tagMapper.listOrderTags();
    }

    //将前台传过来的 (1,2,3,4,5,6)字符串转为一个List
    private List<Long> convertToList(String ids){
        ArrayList<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] split = ids.split(",");
            for (String s : split) {
                list.add(new Long(s));
            }
        }
        return list;
    }
}
