package pers.sunny.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.sunny.blog.entity.Message;
import pers.sunny.blog.mapper.MessageMapper;
import pers.sunny.blog.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 留言数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    @Override
    public List<Message> listMessage() {
        //查询出父节点
        List<Message> messages = messageMapper.listMessageByBlogIdAndParentMessageId(-1L);
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageMapper.listMessageByBlogIdAndParentMessageId(id);
            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    @Override
    public Integer saveMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageMapper.deleteById(id);
    }


    /**
     * @Author Sunny
     * @Description  查询出子留言
     * @Date 2020/8/17
     * @Param [childMessages 所有子留言, parentNickname1 父留言的姓名]
     * @return void
     **/
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    /**
     * @Author Sunny
     * @Description  循环迭代找出子集回复
     * @Date 2020/8/17
     * @Param [childId  子留言的id, parentNickname1  子留言的姓名]
     * @return void
     **/
    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messageMapper.listMessageByBlogIdAndParentMessageId(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }
}
