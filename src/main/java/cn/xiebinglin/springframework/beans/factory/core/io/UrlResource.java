package cn.xiebinglin.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description 通过 HTTP 的方式读取云服务的文件
 * @Author Xie Binglin
 * @create 2022/10/19 9:33
 **/
public class UrlResource implements Resource {
    private final URL url;
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();
        }catch (IOException e){
            if(urlConnection instanceof HttpsURLConnection){
                ((HttpsURLConnection) urlConnection).disconnect();
            }
            throw e;
        }

    }
    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }
}
