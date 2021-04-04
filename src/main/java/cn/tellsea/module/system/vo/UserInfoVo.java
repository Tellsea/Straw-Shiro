package cn.tellsea.module.system.vo;

import cn.tellsea.module.system.entity.ResourceInfo;
import cn.tellsea.module.system.entity.RoleInfo;
import cn.tellsea.module.system.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Tellsea
 * @date 2021/03/31
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserInfoVo extends UserInfo {

    private String type;

    private String roleIds;

    private String roleName;

    private List<RoleInfo> roleInfoList;

    private List<ResourceInfo> resourceInfoList;

    private String oldPassword;
}
