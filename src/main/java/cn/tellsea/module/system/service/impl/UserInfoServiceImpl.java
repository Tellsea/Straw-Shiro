package cn.tellsea.module.system.service.impl;

import cn.tellsea.frame.consts.SessionConst;
import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.frame.shiro.util.ShiroUtils;
import cn.tellsea.module.system.entity.MapUserRole;
import cn.tellsea.module.system.entity.UserInfo;
import cn.tellsea.module.system.mapper.MapUserRoleMapper;
import cn.tellsea.module.system.mapper.ResourceInfoMapper;
import cn.tellsea.module.system.mapper.RoleInfoMapper;
import cn.tellsea.module.system.mapper.UserInfoMapper;
import cn.tellsea.module.system.service.MapUserRoleService;
import cn.tellsea.module.system.service.UserInfoService;
import cn.tellsea.module.system.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private MapUserRoleService mapUserRoleService;
    @Autowired
    private MapUserRoleMapper mapUserRoleMapper;
    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public int countByTable(UserInfoVo entity) {
        return baseMapper.countByTable(entity);
    }

    @Override
    public List<UserInfoVo> listByTable(UserInfoVo entity) {
        return baseMapper.listByTable(entity);
    }

    @Override
    public ResponseResult saveEntity(UserInfoVo entity) {
        List<UserInfo> existList = baseMapper.selectList(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getName, entity.getName()));
        if (!CollectionUtils.isEmpty(existList)) {
            return ResponseResult.error("用户名已存在");
        }
        entity.setSalt(ShiroUtils.genRandomSalt());
        entity.setPassword(ShiroUtils.genPassword("123456", entity.getSalt()));
        baseMapper.insert(entity);
        saveBatchMapUserRole(entity);
        return ResponseResult.success("新增成功");
    }

    @Override
    public ResponseResult updateEntity(UserInfoVo entity) {
        List<UserInfo> existList = baseMapper.selectList(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getName, entity.getName()));
        if (!CollectionUtils.isEmpty(existList) && existList.size() > 1) {
            return ResponseResult.error("数据库存在多个用户名：" + entity.getName());
        } else if (existList.size() == 1 && !existList.get(0).getId().equals(entity.getId())) {
            return ResponseResult.error("用户名已存在：" + entity.getName());
        } else {
            baseMapper.updateById(entity);
            if (StringUtils.isNotEmpty(entity.getRoleIds())) {
                mapUserRoleMapper.delete(new LambdaQueryWrapper<MapUserRole>()
                        .eq(MapUserRole::getUserId, entity.getId()));
                saveBatchMapUserRole(entity);
            }
        }
        return ResponseResult.success("更新成功");
    }

    @Override
    public ResponseResult resetPwd(UserInfoVo entity) {
        if (entity.getId() != null && entity.getId() > 0) {
            entity.setSalt(ShiroUtils.genRandomSalt());
            entity.setPassword(ShiroUtils.genPassword("123456", entity.getSalt()));
            return ResponseResult.success("重置成功");
        } else {
            return ResponseResult.success("重置失败，ID不能为空");
        }
    }

    @Override
    public UserInfoVo getByName(String userName) {
        UserInfoVo userInfoVo = new UserInfoVo();
        UserInfo userInfo = baseMapper.selectOne(
                new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getName, userName));
        BeanUtils.copyProperties(userInfo, userInfoVo);
        userInfoVo.setRoleInfoList(roleInfoMapper.listByUserId(userInfoVo.getId()));
        userInfoVo.setResourceInfoList(resourceInfoMapper.listByUserId(userInfoVo.getId()));
        return userInfoVo;
    }

    @Override
    public ResponseResult updateInfoOrPwdById(UserInfoVo entity) {
        UserInfoVo userInfoVo = (UserInfoVo) ShiroUtils.getSessionAttribute(SessionConst.USER_INFO_SESSION);
        entity.setId(userInfoVo.getId());
        if ("1".equals(entity.getType())) {
            baseMapper.updateById(entity);
            ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION, getByName(entity.getName()));
            return ResponseResult.success("更新成功");
        } else if ("2".equals(entity.getType())) {
            if (StringUtils.isNotEmpty(entity.getOldPassword()) && StringUtils.isNotEmpty(entity.getPassword())) {
                String oldPassword = ShiroUtils.genPassword(entity.getOldPassword(), userInfoVo.getSalt());
                if ((oldPassword.equals(userInfoVo.getPassword()))) {
                    baseMapper.updateById(new UserInfo().setId(userInfoVo.getId())
                            .setPassword(ShiroUtils.genPassword(entity.getPassword(), userInfoVo.getSalt())));
                    return ResponseResult.success("修改成功");
                } else {
                    return ResponseResult.error("旧密码错误");
                }
            } else {
                return ResponseResult.error("更新密码不能为空");
            }
        } else {
            return ResponseResult.error("更新类型不能为空");
        }
    }

    private void saveBatchMapUserRole(UserInfoVo entity) {
        List<MapUserRole> list = new ArrayList<>();
        String[] split = entity.getRoleIds().split(",");
        for (int i = 0; i < split.length; i++) {
            list.add(new MapUserRole().setUserId(entity.getId()).setRoleId(Integer.valueOf(split[i])));
        }
        mapUserRoleService.saveBatch(list, list.size());
    }
}
