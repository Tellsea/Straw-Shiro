package cn.tellsea.module.system.mapper;

import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.vo.ResourceInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface ResourceInfoMapper extends BaseMapper<ResourceInfo> {

    List<ResourceInfoVo> listByTable();

    List<ResourceInfo> listByUserId(@Param("userId") Integer userId);
}
