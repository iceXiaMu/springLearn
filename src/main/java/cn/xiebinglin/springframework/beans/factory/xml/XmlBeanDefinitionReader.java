package cn.xiebinglin.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.xiebinglin.springframework.beans.BeansException;
import cn.xiebinglin.springframework.beans.factory.BeanReference;
import cn.xiebinglin.springframework.beans.factory.PropertyValue;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;
import cn.xiebinglin.springframework.beans.factory.core.io.Resource;
import cn.xiebinglin.springframework.beans.factory.core.io.ResourceLoader;
import cn.xiebinglin.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.xiebinglin.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Struct;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/19 10:10
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
        }catch (IOException  e){
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {

    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }
    protected void doLoadBeanDefinitions(InputStream inputStream)throws ClassNotFoundException{
        Document document = XmlUtil.readXML(inputStream);
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        for (int i=0;i<nodeList.getLength();i++){
            //判断是否是元素，不是元素则跳过
            if(!(nodeList.item(i) instanceof Element))continue;
            //判断是否是对象
            if(!nodeList.item(i).getNodeName().equals("bean"))continue;

            //解析标签
            Element bean = (Element) nodeList.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //获取class
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            //定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //读取属性并填充
            for (int j=0;i<nodeList.getLength();j++){
                if(!(nodeList.item(i) instanceof Element))continue;
                if (nodeList.item(i).getNodeName().equals("property"))continue;
                // 解析标签：property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                //获取属性值
                Object value = StrUtil.isNotEmpty(attrRef)?new BeanReference(attrRef):attrValue;
                //创建属性
                PropertyValue propertyValue = new PropertyValue(attrName,value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
                if(getRegistry().containsBeanDefinition(beanName)){
                    throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
                }
                getRegistry().registerBeanDefinition(beanName,beanDefinition);
            }
        }
    }
}
