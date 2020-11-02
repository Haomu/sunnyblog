package pers.sunny.blog.service;

import pers.sunny.blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标签数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface TagService extends IService<Tag> {
    Tag getTag(Long id);

    List<Tag> listTags();

    void deleteTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag(String tagIds);

    List<Tag> listLimitTag(Integer size);

    void updateTagBlogsByTagIds();

    List<Long> getTagIds();

    List<Tag> listOrderTags();
}
