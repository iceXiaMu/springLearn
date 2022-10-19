package cn.xiebinglin.springframework.beans.factory;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/18 11:26
 **/
public class PropertyValue {
    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
