package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.core.io.BeanDefinitionReader;
import cn.xiebinglin.springframework.beans.factory.core.io.DefaultResourceLoader;
import cn.xiebinglin.springframework.beans.factory.core.io.Resource;
import cn.xiebinglin.springframework.beans.factory.core.io.ResourceLoader;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/19 9:53
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

}
