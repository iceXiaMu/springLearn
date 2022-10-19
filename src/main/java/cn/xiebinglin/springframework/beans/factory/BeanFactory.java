package cn.xiebinglin.springframework.beans.factory;

import java.io.PrintWriter;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 15:58
 **/
public interface BeanFactory {
    Object getBean(String name);
    Object getBean(String name,Object... arg);
}
