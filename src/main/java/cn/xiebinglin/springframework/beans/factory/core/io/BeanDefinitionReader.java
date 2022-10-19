package cn.xiebinglin.springframework.beans.factory.core.io;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/19 9:50
 **/
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
}
