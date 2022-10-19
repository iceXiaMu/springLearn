package cn.xiebinglin.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;
import com.sun.org.apache.regexp.internal.RE;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/19 9:39
 **/
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (MalformedURLException e){
                return new FileSystemResource(location);
            }
        }
    }
}
