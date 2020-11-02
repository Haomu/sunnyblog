package pers.sunny.blog.service;

import pers.sunny.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户数据表 服务类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
public interface UserService extends IService<User> {
    /**
     * @Author Sunny
     * @Description  登录
     * @Date 2020/8/4
     * @Param []
     * @return void
     **/
    User getUserByName(String username);
}
