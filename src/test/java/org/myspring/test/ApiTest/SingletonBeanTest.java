package org.myspring.test.ApiTest;

import org.myspring.BeanDefinition;
import org.myspring.SimpleBeanFactory;
import org.myspring.test.bean.UserService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

public class SingletonBeanTest {
    @Test
    public void test_SingletonBean() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(Class.forName("org.myspring.test.bean.UserService"));
        simpleBeanFactory.registerBean("userService", beanDefinition);
        UserService userService1 = (UserService) simpleBeanFactory.getBean("userService");
        userService1.queryUserInfo();
        UserService userService2 = (UserService) simpleBeanFactory.getBean("userService");
        assertEquals(userService1, userService2);

    }
}
