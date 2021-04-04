package cn.tellsea.module.system.entity;

import cn.tellsea.frame.dto.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("resource_info")
@ApiModel(value = "ResourceInfo对象", description = "资源表")
public class ResourceInfo extends BaseEntity {

    @ApiModelProperty(value = "资源编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "资源名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "父级ID")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty(value = "URL")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "权限标识")
    @TableField("perms")
    private String perms;

    @ApiModelProperty(value = "0 未使用 1 菜单 2 按钮 3 链接")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否可见 1-是 2-否")
    @TableField("is_visible")
    private Integer isVisible;

    @ApiModelProperty(value = "创建人")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "状态 1-正常 2-删除")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;

}
