package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 16:35
 **/
public interface BeanDefinitionRegistry {
    //向注册表中注册BeanDefinition
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    boolean containsBeanDefinition(String beanName);
}
