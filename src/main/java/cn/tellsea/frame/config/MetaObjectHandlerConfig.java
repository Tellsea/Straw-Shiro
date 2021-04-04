package cn.tellsea.frame.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author Tellsea
 * @date 2021/03/31
 */
@Configuration
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createUser", 1, metaObject);
        setFieldValByName("createTime", new Date(), metaObject);
        setFieldValByName("status", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
