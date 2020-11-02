package pers.sunny.blog.service;

import pers.sunny.blog.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 留言数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface MessageService extends IService<Message> {

    List<Message> listMessage();

    Integer saveMessage(Message message);

    void deleteMessage(Long id);

}
