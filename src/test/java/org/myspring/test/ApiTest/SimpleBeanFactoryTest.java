package org.myspring.test.ApiTest;

import org.myspring.BeanDefinition;
import org.myspring.SimpleBeanFactory;
import org.myspring.test.bean.UserService;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class SimpleBeanFactoryTest {
    @Test
    public void test_SimpleBeanFactory() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(Class.forName("org.myspring.test.bean.UserService"));
        simpleBeanFactory.registBean("userService", beanDefinition);

        UserService userService = (UserService) simpleBeanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
