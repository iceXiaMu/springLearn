package cn.xiebinglin.springframework.beans.factory;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/18 11:22
 **/
public class BeanReference {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
