package cn.tellsea.frame.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis plus 配置
 *
 * @author Tellsea
 * @date 2021/03/29
 */
@Configuration
@MapperScan("cn.tellsea.module.*.mapper")
public class MybatisPlusConfig {

}
