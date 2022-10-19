package cn.xiebinglin.springframework.beans.factory.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description 通过指定文件路径的方式读取文件信息
 * @Author Xie Binglin
 * @create 2022/10/19 9:29
 **/
public class FileSystemResource implements Resource {
    private final String path;
    private final File file;
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public String getPath() {
        return this.path;
    }
}
