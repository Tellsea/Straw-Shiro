package cn.tellsea.frame.shiro.realm;

import cn.tellsea.frame.consts.SessionConst;
import cn.tellsea.frame.shiro.util.ShiroUtils;
import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.entity.RoleInfo;
import cn.tellsea.module.system.entity.UserInfo;
import cn.tellsea.module.system.service.UserInfoService;
import cn.tellsea.module.system.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 认证授权验证域
 *
 * @author Tellsea
 * @date 2019/7/13
 * Shiro 事物失效问题：https://blog.csdn.net/finalcola/article/details/81197584
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 在Realm中Service声明上加入@Lazy注解，延迟Realm实现中Service对象的初始化时间，
     * 这样就可以保证Service实际初始化的时候会被BeanPostProcessor拦截，创建具有事务功能的代理对象
     */
    @Lazy
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInfoVo user = (UserInfoVo) ShiroUtils.getSessionAttribute(SessionConst.USER_INFO_SESSION);
        if (!CollectionUtils.isEmpty(user.getRoleInfoList())) {
            List<String> roleList = user.getRoleInfoList().stream().map(RoleInfo::getRole).collect(Collectors.toList());
            info.addRoles(roleList);
        }
        if (!CollectionUtils.isEmpty(user.getResourceInfoList())) {
            List<String> resList = user.getResourceInfoList().stream()
                    .filter(item -> StringUtils.isNotEmpty(item.getPerms()))
                    .distinct()
                    .map(ResourceInfo::getPerms).collect(Collectors.toList());
            info.addStringPermissions(resList);
            for (String res : resList) {
                if (StringUtils.isNotEmpty(res) && !"null".equals(res)) {
                    System.out.println("_" + res);
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        List<UserInfo> list = userInfoService.list(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getName, userName));
        if (CollectionUtils.isEmpty(list) || list.size() != 1) {
            throw new UnknownAccountException();
        }
        UserInfo user = list.get(0);
        // 防止泄露，shiro将SimpleAuthenticationInfo的第一个参数存入标签中
        /*user.setPassword("");
        user.setSalt("");*/
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }

    @Override
    public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        // 获得当前用户的信息，底层会从先尝试从缓存中取，若不存在会执行 doGetAuthorizationInfo 方法，并写入缓存中
        return super.getAuthorizationInfo(principals);
    }
}
