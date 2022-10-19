package cn.xiebinglin.springframework.beans;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 16:04
 **/
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
