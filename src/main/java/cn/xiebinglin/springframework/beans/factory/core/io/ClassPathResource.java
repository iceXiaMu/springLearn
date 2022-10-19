package cn.xiebinglin.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description 通过 ClassLoader 读取 ClassPath 下的文件信息
 * @Author Xie Binglin
 * @create 2022/10/19 9:20
 **/
public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;
    @Override
    public InputStream getInputStream() throws IOException {
        //通过classLoader读取classPath下的文件
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null){
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }

    public ClassPathResource(String path) {
        this(path,null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }
}
