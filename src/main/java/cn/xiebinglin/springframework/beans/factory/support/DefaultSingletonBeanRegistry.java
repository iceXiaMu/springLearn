package cn.xiebinglin.springframework.beans.factory.support;

import cn.xiebinglin.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 15:51
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleTon(String beanName) {
        return singletonObjects.get(beanName);
    }
    //定义一个受保护的方法，此方法可以被继承此类的类调用
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
