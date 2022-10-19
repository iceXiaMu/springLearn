package bean;

/**
 * @description
 * @Author Xie Binglin
 * @create 2022/10/14 15:10
 **/
public class UserService {
    private String name;
    //在 UserService 中注入UserDao，这样就能体现出 Bean 属性的依赖了
    private UserDao userDao;
    private String uId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserService(String name) {
        this.name = name;
    }
    public UserService(){

    }
    public void queryInfo(){
        System.out.println(name+":"+"天道好轮回，苍天饶过谁");
    }

    public void queryInfoByUser(){
        System.out.println(userDao.queryByUId(uId));
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

}
