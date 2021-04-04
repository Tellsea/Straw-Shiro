package cn.tellsea.module.system.service.impl;

import cn.tellsea.frame.dto.layuimini.CheckArr;
import cn.tellsea.frame.dto.layuimini.DTree;
import cn.tellsea.frame.dto.layuimini.MenuInfo;
import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.mapper.ResourceInfoMapper;
import cn.tellsea.module.system.service.ResourceInfoService;
import cn.tellsea.module.system.vo.ResourceInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Service
public class ResourceInfoServiceImpl extends ServiceImpl<ResourceInfoMapper, ResourceInfo> implements ResourceInfoService {

    @Override
    public List<ResourceInfoVo> listByTable() {
        return baseMapper.listByTable();
    }

    @Override
    public List<MenuInfo> listAllByMenu() {
        List<ResourceInfo> list = baseMapper.selectList(new LambdaQueryWrapper<ResourceInfo>()
                .orderByAsc(ResourceInfo::getSort).eq(ResourceInfo::getType, 1)
                .eq(ResourceInfo::getIsVisible, 1));
        return treeMenuList(list, 0);
    }

    @Override
    public Map<String, Object> listByDTree() {
        List<ResourceInfo> list = baseMapper.selectList(new LambdaQueryWrapper<ResourceInfo>()
                .orderByAsc(ResourceInfo::getSort));
        List<DTree> dTreeList = dTreeList(list, 0);
        Map<String, Object> code = new HashMap<>(16);
        code.put("code", 200);
        code.put("message", "查询成功");
        Map<String, Object> result = new HashMap<>(16);
        result.put("status", code);
        result.put("data", dTreeList);
        return result;
    }

    public List<MenuInfo> treeMenuList(List<ResourceInfo> list, int parentId) {
        List<MenuInfo> menuList = new ArrayList<>();
        for (ResourceInfo res : list) {
            if (res.getPid().equals(parentId)) {
                menuList.add(new MenuInfo()
                        .setTitle(res.getName())
                        .setIcon("fa " + res.getIcon())
                        .setHref(res.getUrl())
                        .setTarget("_self")
                        .setChild(treeMenuList(list, res.getId())));
            }
        }
        return menuList;
    }

    public List<DTree> dTreeList(List<ResourceInfo> list, int parentId) {
        List<DTree> resultList = new ArrayList<>();
        for (ResourceInfo res : list) {
            if (res.getPid().equals(parentId)) {
                resultList.add(new DTree()
                        .setId(res.getId())
                        .setTitle(res.getName())
                        .setSpread(true)
                        .setParentId(res.getPid())
                        .setCheckArr(Arrays.asList(new CheckArr().setType(0).setChecked(0)))
                        .setChildren(dTreeList(list, res.getId())));
            }
        }
        return resultList;
    }
}
