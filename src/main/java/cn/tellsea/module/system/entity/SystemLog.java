package cn.tellsea.module.system.entity;

import cn.tellsea.frame.dto.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author Tellsea
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_log")
@ApiModel(value = "SystemLog对象", description = "系统日志表")
public class SystemLog extends BaseEntity {


    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "操作用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "操作描述")
    @TableField("operation")
    private String operation;

    @ApiModelProperty(value = "耗时(毫秒)")
    @TableField("time")
    private Integer time;

    @ApiModelProperty(value = "操作方法")
    @TableField("method")
    private String method;

    @ApiModelProperty(value = "操作参数")
    @TableField("params")
    private String params;

    @ApiModelProperty(value = "IP地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "操作时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "操作地点")
    @TableField("location")
    private String location;


}
