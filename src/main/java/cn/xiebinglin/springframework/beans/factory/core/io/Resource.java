package cn.xiebinglin.springframework.beans.factory.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/19 9:19
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
