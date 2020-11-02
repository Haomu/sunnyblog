package pers.sunny.blog.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.sunny.blog.entity.User;
import pers.sunny.blog.service.impl.UserServiceImpl;

/**
 * @Description
 * @Author Sunny
 * @Version 1.0
 * @Date 2020-08-03-23:34
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    /**
     * @Author Sunny
     * @Description  授权
     * @Date 2020/8/3
     * @Param [principalCollection]
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @Author Sunny
     * @Description  认证
     * @Date 2020/8/3
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserByName(token.getUsername());
        if (user == null){
            return null;
        }
        //1.认证的实体信息，可以是username，也可以是用户实体类对象
        //2.credentials密码
        String credentials = user.getPassword();
        //3.realmName,当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        //4.盐值加密
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());

        return new SimpleAuthenticationInfo(user,credentials,credentialsSalt,realmName);
    }
}
