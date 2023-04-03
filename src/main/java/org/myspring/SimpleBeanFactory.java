package org.myspring;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();
    private Map<String, Object> beanHashMap = new HashMap<>();

    public void registerBean(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object bean = beanHashMap.get(beanName);
        if(bean == null) {
            bean = createBean(beanName);
        }
        return bean;
    }

    private Object createBean(String beanName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BeanDefinition beanDefinition = beanDefinitionHashMap.get(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> constructor = beanClass.getDeclaredConstructor();
        Object bean = constructor.newInstance();
        beanHashMap.put(beanName, bean);
        return bean;
    }
}
