package cn.tellsea.module.system.mapper;

import cn.tellsea.module.system.entity.RoleInfo;
import cn.tellsea.module.system.vo.RoleInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    int countByTable(@Param("entity") RoleInfoVo entity);

    List<RoleInfoVo> listByTable(@Param("entity") RoleInfoVo entity);

    List<RoleInfo> listByUserId(@Param("userId") Integer userId);
}
