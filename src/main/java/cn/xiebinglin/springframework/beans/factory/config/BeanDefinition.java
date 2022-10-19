package cn.xiebinglin.springframework.beans.factory.config;

import cn.xiebinglin.springframework.beans.factory.PropertyValue;
import cn.xiebinglin.springframework.beans.factory.PropertyValues;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 15:40
 **/
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues!=null?propertyValues:new PropertyValues();
    }
}
