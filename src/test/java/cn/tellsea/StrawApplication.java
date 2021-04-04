package cn.tellsea;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;
import cn.hutool.db.sql.Condition;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tellsea
 * @date 2021/03/31
 */
@SpringBootTest
public class StrawApplication {

    @Test
    public void password() {
        Md5Hash md5Hash = new Md5Hash("123456", "5jRDdrkfYL3VOJYT6ZgTY95jJ3q93q8A", 2);
        System.out.println(md5Hash);
        System.out.println(StringUtils.equals("a994fef0ddad5f9eed20804e7b18f559", md5Hash.toString()));
    }

    @Test
    public void dataSource() {
        // https://hutool.cn/docs/#/db/%E6%95%B0%E6%8D%AE%E6%BA%90%E5%B7%A5%E5%8E%82-DsFactory
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/straw_shiro?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        Entity where = Entity.create("test").set("条件1", "条件值");

        try {
            Db.use(dataSource).insert(
                    Entity.create("user")
                            .set("name", "unitTestUser")
                            .set("age", 66));

            Db.use().del(
                    Entity.create("user").set("name", "unitTestUser")//where条件
            );

            Db.use().update(
                    Entity.create().set("age", 88), //修改的数据
                    Entity.create("user").set("name", "unitTestUser") //where条件
            );

            Db.use().findAll("user");
            Db.use().findAll(Entity.create("user").set("name", "unitTestUser"));
            Db.use().findLike("user", "name", "Test", Condition.LikeType.Contains);
            List<Entity> find = Db.use().find(Entity.create("user").set("name", "like 王%"));
            //Page对象通过传入页码和每页条目数达到分页目的
            PageResult<Entity> result = Db.use().page(Entity.create("user").set("age", "> 30"), new Page(10, 20));

            //查询
            //List<Entity> result = Db.use().query("select * from user where age < ?", 3);
            //模糊查询
            //List<Entity> result = Db.use().query("select * from user where name like ?", "王%");
            //新增
            Db.use().execute("insert into user values (?, ?, ?)", "张三", 17, 1);
            //删除
            Db.use().execute("delete from user where name = ?", "张三");
            //更新
            Db.use().execute("update user set age = ? where name = ?", 3, "张三");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
