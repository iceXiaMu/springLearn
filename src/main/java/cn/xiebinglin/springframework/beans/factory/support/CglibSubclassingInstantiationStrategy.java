package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/17 16:52
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null)return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
