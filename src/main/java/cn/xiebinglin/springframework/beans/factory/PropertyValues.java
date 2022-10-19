package cn.xiebinglin.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/18 11:28
 **/
public class PropertyValues {
    List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue:this.propertyValueList){
            if(propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }
}
