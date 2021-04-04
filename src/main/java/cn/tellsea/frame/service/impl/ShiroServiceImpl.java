package cn.tellsea.frame.service.impl;

import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.mapper.ResourceInfoMapper;
import cn.tellsea.module.system.mapper.UserInfoMapper;
import cn.tellsea.frame.service.ShiroService;
import cn.tellsea.frame.shiro.filter.SessionCheckFilter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * shiro service 实现类
 *
 * @author: Tellsea
 * @date: 2019/09/05
 * 参考文章：https://blog.csdn.net/batter_hwb/article/details/83792775
 */
@Slf4j
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public ShiroFilterFactoryBean loadShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 自定义拦截器
        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("sessionCheckFilter", new SessionCheckFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
        return shiroFilterFactoryBean;
    }

    @Override
    public Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /*List<ResourceInfo> list = resourceInfoMapper.selectList(new LambdaQueryWrapper<>());
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(resourceInfo -> {
                // 同时存在请求路径、授权，则添加到拦截器中
                if (!StringUtils.isEmpty(resourceInfo.getUrl()) && !StringUtils.isEmpty(resourceInfo.getPerms())) {
                    filterChainDefinitionMap.put(resourceInfo.getUrl(), "perms[\"" + resourceInfo.getPerms() + "\"]");
                }
            });
        }*/
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/druid", "anon");
        filterChainDefinitionMap.put("/Captcha.jpg", "anon");
        filterChainDefinitionMap.put("/403", "anon");
        filterChainDefinitionMap.put("/404", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/**", "user,sessionCheckFilter");
        return filterChainDefinitionMap;
    }

    @Override
    public void updatePermission() {
        synchronized (this) {
            ShiroFilterFactoryBean shiroFilterFactoryBean = loadShiroFilterFactoryBean();
            shiroFilterFactoryBean.setSecurityManager(SecurityUtils.getSecurityManager());

            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                log.error("ShiroServiceImpl: 从 ShirofilterFactoryBean 错误获取 Shirofilter !");
                throw new RuntimeException("从 ShirofilterFactoryBean 错误获取 Shirofilter !");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            log.info("ShiroServiceImpl: 清空旧的权限控制...");
            manager.getFilterChains().clear();
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());

            log.info("ShiroServiceImpl: 重新构建权限控制的过滤链...");
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }
}
