package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/18 13:38
 **/
public class UserDao {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("1001","蜡笔小新");
        map.put("1002","工藤新一");
        map.put("1003","东方不败");
    }
    public String queryByUId(String uId){
        return map.get(uId);
    }
}
