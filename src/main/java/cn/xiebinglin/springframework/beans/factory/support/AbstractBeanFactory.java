package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.BeanFactory;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;

/**
 * @description 继承了DefaultSingletonBeanRegistry，也就代表拥有了单例注册类方法
 * @Author Xie Binglin
 * @create 2022/10/14 15:57
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleTon(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object... args) throws BeansException;
}
