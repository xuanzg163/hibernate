package test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import test.hibernate.entity.User;

/**
 * @author zhangxuan
 * @date 2018/11/28
 * @time 10:57
 */

public class TestHibernate {

    @Test
    public void test01() {
        //1. 加载配置文件
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        // 2. 通过注册中心生成SessionFactory
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        User user = (User) session.get(User.class, 1);
        System.out.println(user);
        session.close();
    }
}
