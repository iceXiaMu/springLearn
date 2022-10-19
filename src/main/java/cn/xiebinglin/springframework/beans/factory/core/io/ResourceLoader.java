package cn.xiebinglin.springframework.beans.factory.core.io;

/**
 * @description 包资源加载器
 * @Author Xie Binglin
 * @create 2022/10/19 9:37
 **/
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";
    Resource getResource(String location);
}
