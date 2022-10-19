package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/17 14:09
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance();
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
