package org.myspring;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    public void registBean(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BeanDefinition beanDefinition = beanDefinitionHashMap.get(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> constructor = beanClass.getDeclaredConstructor();
        return constructor.newInstance();
    }
}
