package pers.sunny.blog.service.impl;

import pers.sunny.blog.entity.Picture;
import pers.sunny.blog.mapper.PictureMapper;
import pers.sunny.blog.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册数据表 服务实现类
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

}
