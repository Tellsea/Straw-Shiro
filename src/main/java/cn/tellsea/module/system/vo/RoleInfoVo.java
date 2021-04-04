package cn.tellsea.module.system.vo;

import cn.tellsea.module.system.entity.RoleInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Tellsea
 * @date 2021/03/31
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class RoleInfoVo extends RoleInfo {

    private String resourceIds;
}
