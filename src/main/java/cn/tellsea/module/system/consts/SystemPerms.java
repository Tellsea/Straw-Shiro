package cn.tellsea.module.system.consts;

/**
 * system 模块权限常量
 *
 * @author Tellsea
 * @date 2021/04/04
 */
public class SystemPerms {

    public class UserInfo {
        public static final String VIEW = "system:userInfo:view";
        public static final String LIST = "system:userInfo:list";
        public static final String SAVE = "system:userInfo:save";
        public static final String UPDATE = "system:userInfo:update";
        public static final String DELETE = "system:userInfo:delete";
        public static final String IMPORT = "system:userInfo:import";
        public static final String EXPORT = "system:userInfo:export";
        public static final String RESET_PWD = "system:userInfo:resetPwd";
    }

    public class RoleInfo {
        public static final String VIEW = "system:roleInfo:view";
        public static final String LIST = "system:roleInfo:list";
        public static final String SAVE = "system:roleInfo:save";
        public static final String UPDATE = "system:roleInfo:update";
        public static final String DELETE = "system:roleInfo:delete";
    }

    public class ResourceInfo {
        public static final String VIEW = "system:resourceInfo:view";
        public static final String LIST = "system:resourceInfo:list";
        public static final String SAVE = "system:resourceInfo:save";
        public static final String UPDATE = "system:resourceInfo:update";
        public static final String DELETE = "system:resourceInfo:delete";
    }
}
