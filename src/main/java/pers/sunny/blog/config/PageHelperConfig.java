package pers.sunny.blog.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-05-16:26
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper createPageHelper(){
        return new PageHelper();
    }
}
