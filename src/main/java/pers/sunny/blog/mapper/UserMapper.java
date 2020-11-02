package pers.sunny.blog.mapper;

import org.springframework.stereotype.Repository;
import pers.sunny.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户数据表 Mapper 接口
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Repository
public interface UserMapper extends BaseMapper<User> {


}
