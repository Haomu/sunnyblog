package pers.sunny.blog.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-03-23:30
 */
@Configuration
public class ShiroConfig {

    //三大对象
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置加密算法
        matcher.setHashAlgorithmName("MD5");
        //设置加密次数
        matcher.setHashIterations(1024);
        //是否存储为16进制
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    //1.创建realm对象，将自己的验证方式加入容器
    @Bean
    public UserRealm myUserRealm(){
        UserRealm shiroRealm = new UserRealm();
        //设置加密算法
        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        return shiroRealm;
    }

    //2.DefaultWebSecurityManager，权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联UserRealm
        manager.setRealm(myUserRealm());
        return manager;
    }

    //3.ShiroFilterFactoryBean，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(securityManager());

        //添加Shiro内置过滤器
        Map<String, String> map = new LinkedHashMap<>();
        //注意这里过滤是从前往后读取
        map.put("/manage/login","anon");
        map.put("/manage/toLogin","anon");
        map.put("/manage/**","authc");

        //配置静态资源
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/manage/toLogin");
        factoryBean.setSuccessUrl("/manage/success");

        return factoryBean;
    }




}
