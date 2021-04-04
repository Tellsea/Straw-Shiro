package cn.tellsea.module.system.vo;

import cn.tellsea.module.system.entity.ResourceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Tellsea
 * @date 2021/04/02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ResourceInfoVo extends ResourceInfo {

    private String pidName;
}
