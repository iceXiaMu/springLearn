package cn.xiebinglin.springframework.beans.factory.config;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 15:46
 **/
public interface SingletonBeanRegistry {
//    定义一个单例获取对象
    Object getSingleTon(String beanName);
}
