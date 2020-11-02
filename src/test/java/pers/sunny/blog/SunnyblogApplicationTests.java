package pers.sunny.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.sunny.blog.entity.Blog;
import pers.sunny.blog.entity.User;
import pers.sunny.blog.mapper.BlogMapper;
import pers.sunny.blog.mapper.TagMapper;
import pers.sunny.blog.mapper.TypeMapper;
import pers.sunny.blog.service.impl.BlogServiceImpl;
import pers.sunny.blog.service.impl.CommentServiceImpl;
import pers.sunny.blog.service.impl.UserServiceImpl;


import java.util.List;
import java.util.Map;

@SpringBootTest
class SunnyblogApplicationTests {

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private CommentServiceImpl commentService;

    @Test
    void contextLoads() {
        User user = userService.getUserByName("admin");
        System.out.println(user);
    }

    @Test
    void test1(){
        String password = "Zhang2000..";
        ByteSource salt = ByteSource.Util.bytes("sunny");
        System.out.println(new SimpleHash("MD5",password,salt,1024).toHex());
    }
    @Test
    void test2() {
        Blog blog = new Blog();
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(blog.getTitle()),"title",blog.getTitle())
                .like(ObjectUtils.isNotNull(blog.getTypeId()),"type_id",blog.getTypeId())
                .like(blog.getRecommend(),"recommend",blog.getRecommend());

        blogMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void test3() {
        tagMapper.listLimitTag(10).forEach(System.out::println);
    }

    @Test
    void test4(){
        List<Long> tagIds = tagMapper.getTagIds();
        for (Long tagId : tagIds) {
            tagMapper.updateTagBlogsByTagIds(tagId);
        }
    }

    @Test
    void test5(){
        blogService.listBlogsByQuery("测试").forEach(System.out::println);
    }

    @Test
    void test6(){
        blogService.listBlogsByTypeId(1290951771594031105L).forEach(System.out::println);
    }

    @Test
    void test7(){
        typeMapper.updateTagBlogsByTypeIds(1290951569965531138L);
    }

    @Test
    void test8(){
        blogService.listBlogsByTagId(1291254833139408897L).forEach(System.out::println);
    }

    @Test
    void test9(){
        Map<String, List<Blog>> stringListMap = blogService.archiveBlog();
        for (String s : stringListMap.keySet()) {
            System.out.println(s);
        }
        System.out.println("*********************");
        for (List<Blog> value : stringListMap.values()) {
            for (Blog blog : value) {
                System.out.println(blog);
            }
        }
    }

    @Test
    void test10(){
        System.out.println(blogService.countBlog());
    }

    @Test
    void test11(){
        commentService.listCommentByBlogId(2112L).forEach(System.out::println);
    }

    @Test
    void test12(){
        commentService.listCommentByBlogId(1292020901801820162L).forEach(System.out::println);
    }

}
