package cn.tellsea.module.system.service.impl;

import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.module.system.entity.MapRoleResource;
import cn.tellsea.module.system.entity.RoleInfo;
import cn.tellsea.module.system.mapper.MapRoleResourceMapper;
import cn.tellsea.module.system.mapper.RoleInfoMapper;
import cn.tellsea.module.system.service.MapRoleResourceService;
import cn.tellsea.module.system.service.RoleInfoService;
import cn.tellsea.module.system.vo.RoleInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {

    @Autowired
    private MapRoleResourceService mapRoleResourceService;
    @Autowired
    private MapRoleResourceMapper mapRoleResourceMapper;

    @Override
    public int countByTable(RoleInfoVo entity) {
        return baseMapper.countByTable(entity);
    }

    @Override
    public List<RoleInfoVo> listByTable(RoleInfoVo entity) {
        List<RoleInfoVo> list = baseMapper.listByTable(entity);
        list.forEach(item -> {
            List<MapRoleResource> mapRoleResources = mapRoleResourceMapper.selectList(
                    new LambdaQueryWrapper<MapRoleResource>().eq(MapRoleResource::getRoleId, item.getId()));
            List<Integer> resourceIds = mapRoleResources.stream().map(MapRoleResource::getResourceId).collect(Collectors.toList());
            item.setResourceIds(Joiner.on(",").join(resourceIds));
        });
        return list;
    }

    @Override
    public ResponseResult saveEntity(RoleInfoVo entity) {
        List<RoleInfo> existList = baseMapper.selectList(new LambdaQueryWrapper<RoleInfo>()
                .eq(RoleInfo::getName, entity.getName()));
        if (!CollectionUtils.isEmpty(existList)) {
            return ResponseResult.error("角色名称已存在");
        }
        baseMapper.insert(entity);
        saveBatchMapRoleResource(entity);
        return ResponseResult.success("新增成功");
    }

    @Override
    public ResponseResult updateEntity(RoleInfoVo entity) {
        List<RoleInfo> existList = baseMapper.selectList(new LambdaQueryWrapper<RoleInfo>()
                .eq(RoleInfo::getName, entity.getName()));
        if (!CollectionUtils.isEmpty(existList) && existList.size() > 1) {
            return ResponseResult.error("数据库存在多个角色名称");
        } else if (existList.size() == 1 && !existList.get(0).getId().equals(entity.getId())) {
            return ResponseResult.error("角色名称已存在");
        } else {
            baseMapper.updateById(entity);
            mapRoleResourceMapper.delete(new LambdaQueryWrapper<MapRoleResource>()
            .eq(MapRoleResource::getRoleId, entity.getId()));
            saveBatchMapRoleResource(entity);
        }
        return ResponseResult.success("更新成功");
    }

    private void saveBatchMapRoleResource(RoleInfoVo entity) {
        if (StringUtils.isNotEmpty(entity.getResourceIds())) {
            List<MapRoleResource> list = new ArrayList<>();
            String[] split = entity.getResourceIds().split(",");
            for (int i = 0; i < split.length; i++) {
                list.add(new MapRoleResource().setRoleId(entity.getId()).setResourceId(Integer.valueOf(split[i])));
            }
            mapRoleResourceService.saveBatch(list, list.size());
        }
    }
}
