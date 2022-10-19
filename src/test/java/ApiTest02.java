import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.xiebinglin.springframework.beans.factory.BeanReference;
import cn.xiebinglin.springframework.beans.factory.PropertyValue;
import cn.xiebinglin.springframework.beans.factory.PropertyValues;
import cn.xiebinglin.springframework.beans.factory.config.BeanDefinition;
import cn.xiebinglin.springframework.beans.factory.core.io.DefaultResourceLoader;
import cn.xiebinglin.springframework.beans.factory.core.io.Resource;
import cn.xiebinglin.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 16:49
 **/
public class ApiTest02 {
    @Test
    public void test(){
//        注册beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
//        获取bean
        UserService userService = (UserService)beanFactory.getBean("userService","蜡笔小新");
        userService.queryInfo();

    }
    //验证无构造函数
    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        //使用类名.newInstance()来实例化类
        try {
            Class clazz = Class.forName("bean.UserService");
            UserService userService = (UserService)clazz.newInstance();
            userService.queryInfo();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    //验证有构造函数实例化
    @Test
    public void test_constructor(){
        Class<UserService> userServiceClass = UserService.class;
        try {
            //获取构造函数
            Constructor<UserService> constructor = userServiceClass.getDeclaredConstructor(String.class);
            //实例化
            UserService userService = constructor.newInstance("蜡笔小新");
            userService.queryInfo();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    //获取所有的构造函数
    @Test
    public void test_parameterTypes(){
        try {
            Class<UserService> userServiceClass = UserService.class;
            Constructor<?>[] constructors = userServiceClass.getDeclaredConstructors();
//            Constructor<?> constructor = constructors[0]; //0是无参的
            Constructor<?> constructor = constructors[1];
            Constructor<UserService> userServiceConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
            UserService userService = userServiceConstructor.newInstance("蜡笔小新");
            userService.queryInfo();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Test
    public void test_cglib(){
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(UserService.class);
            enhancer.setCallback(new NoOp() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            });
            Object o = enhancer.create(new Class[]{String.class},new Object[]{"蜡笔小新"});
            System.out.println(o);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Test
    public void test_BeanFactory(){
        //初始化bean
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //UserDao注册
        factory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        //UserService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //UserService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        factory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryInfoByUser();
    }
    private DefaultResourceLoader defaultResourceLoader;
    @Before
    public void init() {
        defaultResourceLoader = new DefaultResourceLoader();
    }
    @Test
    public void test_classpathOrFileOrUrl()throws IOException {
//        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
//        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        Resource resource = defaultResourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
