package cn.tellsea.module.system.mapper;

import cn.tellsea.module.system.entity.UserInfo;
import cn.tellsea.module.system.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int countByTable(@Param("entity") UserInfoVo entity);

    List<UserInfoVo> listByTable(@Param("entity") UserInfoVo entity);
}
