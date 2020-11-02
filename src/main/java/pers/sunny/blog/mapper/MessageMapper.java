package pers.sunny.blog.mapper;

import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 留言数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> listMessageByBlogIdAndParentMessageId(Long id);
}
