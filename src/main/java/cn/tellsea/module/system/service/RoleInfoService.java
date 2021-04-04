package cn.tellsea.module.system.service;

import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.module.system.entity.RoleInfo;
import cn.tellsea.module.system.vo.RoleInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface RoleInfoService extends IService<RoleInfo> {

    int countByTable(RoleInfoVo entity);

    List<RoleInfoVo> listByTable(RoleInfoVo entity);

    ResponseResult saveEntity(RoleInfoVo entity);

    ResponseResult updateEntity(RoleInfoVo entity);
}
