package cn.tellsea.module.system.service;

import cn.tellsea.frame.dto.layuimini.MenuInfo;
import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.vo.ResourceInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface ResourceInfoService extends IService<ResourceInfo> {

    List<ResourceInfoVo> listByTable();

    List<MenuInfo> listAllByMenu();

    Map<String, Object> listByDTree();
}
