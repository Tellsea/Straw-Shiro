package cn.tellsea.module.system.controller;


import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.module.system.consts.SystemPerms;
import cn.tellsea.module.system.service.RoleInfoService;
import cn.tellsea.module.system.vo.RoleInfoVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Controller
@RequestMapping("/system/roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    @RequiresPermissions(SystemPerms.RoleInfo.VIEW)
    @GetMapping("init")
    public String init() {
        return "admin/role_info/role_info_list";
    }

    @RequiresPermissions(SystemPerms.RoleInfo.LIST)
    @PostMapping("listByTable")
    @ResponseBody
    public ResponseResult listByTable(RoleInfoVo entity) {
        return ResponseResult.table(roleInfoService.countByTable(entity), roleInfoService.listByTable(entity));
    }

    @RequiresPermissions(SystemPerms.RoleInfo.LIST)
    @GetMapping("listByAll")
    @ResponseBody
    public ResponseResult listByAll() {
        return ResponseResult.success("查询成功", roleInfoService.list());
    }

    @RequiresPermissions(SystemPerms.RoleInfo.SAVE)
    @PostMapping("save")
    @ResponseBody
    public ResponseResult save(RoleInfoVo entity) {
        return roleInfoService.saveEntity(entity);
    }

    @RequiresPermissions(SystemPerms.RoleInfo.UPDATE)
    @PostMapping("updateById")
    @ResponseBody
    public ResponseResult updateById(RoleInfoVo entity) {
        return roleInfoService.updateEntity(entity);
    }

    @RequiresPermissions(SystemPerms.RoleInfo.DELETE)
    @PostMapping("deleteById")
    @ResponseBody
    public ResponseResult deleteById(int id) {
        roleInfoService.removeById(id);
        return ResponseResult.success("删除成功");
    }
}
