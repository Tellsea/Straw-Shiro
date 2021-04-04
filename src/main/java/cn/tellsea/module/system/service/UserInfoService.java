package cn.tellsea.module.system.service;

import cn.tellsea.frame.dto.ResponseResult;
import cn.tellsea.module.system.entity.UserInfo;
import cn.tellsea.module.system.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
public interface UserInfoService extends IService<UserInfo> {

    int countByTable(UserInfoVo entity);

    List<UserInfoVo> listByTable(UserInfoVo entity);

    ResponseResult saveEntity(UserInfoVo entity);

    ResponseResult resetPwd(UserInfoVo entity);

    ResponseResult updateEntity(UserInfoVo entity);

    UserInfoVo getByName(String userName);

    ResponseResult updateInfoOrPwdById(UserInfoVo entity);
}
