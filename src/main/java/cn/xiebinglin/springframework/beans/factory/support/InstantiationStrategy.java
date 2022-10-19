package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/17 13:48
 **/
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor
            ctor, Object[] args) throws BeansException;
}
