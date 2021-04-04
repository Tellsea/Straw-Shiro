package cn.tellsea.module.system.controller;


import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.frame.shiro.aop.annotation.DynamicShiro;
import cn.tellsea.module.system.consts.SystemPerms;
import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.service.ResourceInfoService;
import cn.tellsea.module.system.vo.ResourceInfoVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Controller
@RequestMapping("/system/resourceInfo")
public class ResourceInfoController {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @RequiresPermissions(SystemPerms.ResourceInfo.VIEW)
    @GetMapping("init")
    public String init() {
        return "admin/resource_info/resource_info_list";
    }

    @RequiresPermissions(SystemPerms.ResourceInfo.LIST)
    @GetMapping("listByTable")
    @ResponseBody
    public ResponseResult listByTable() {
        List<ResourceInfoVo> list = resourceInfoService.listByTable();
        return ResponseResult.table(list.size(), list);
    }

    @RequiresPermissions(SystemPerms.ResourceInfo.LIST)
    @PostMapping("listByDTree")
    @ResponseBody
    public Map<String, Object> listByDTree() {
        return resourceInfoService.listByDTree();
    }

    @RequiresPermissions(SystemPerms.ResourceInfo.SAVE)
    @PostMapping("save")
    @ResponseBody
    @DynamicShiro
    public ResponseResult save(ResourceInfo entity) {
        resourceInfoService.save(entity);
        return ResponseResult.success("新增成功");
    }

    @RequiresPermissions(SystemPerms.ResourceInfo.UPDATE)
    @PostMapping("updateById")
    @ResponseBody
    @DynamicShiro
    public ResponseResult updateById(ResourceInfo entity) {
        resourceInfoService.updateById(entity);
        return ResponseResult.success("更新成功");
    }

    @RequiresPermissions(SystemPerms.ResourceInfo.DELETE)
    @PostMapping("deleteById")
    @ResponseBody
    @DynamicShiro
    public ResponseResult deleteById(int id) {
        resourceInfoService.removeById(id);
        return ResponseResult.success("删除成功");
    }
}
