package cn.tellsea.module.system.service.impl;

import cn.tellsea.module.system.entity.SystemLog;
import cn.tellsea.module.system.mapper.SystemLogMapper;
import cn.tellsea.module.system.service.SystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-31
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

}
