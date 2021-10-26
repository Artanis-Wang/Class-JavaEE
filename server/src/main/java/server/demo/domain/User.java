package server.demo.domain;


/**@author 王梓宇
 * @time 2021.10.18
 * 用户类
 */
import com.sun.codemodel.internal.JCase;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private String token;
    private String pwd;
    private String height;
    private String weight;
    public User(String username, String pwd,String height,String weight)
    {
        this.pwd = pwd;
        this.username = username;
        this.token = "";
        this.height = height;
        this.weight = weight;
    }
    public String getHeight(){return height;}
    public void setHeight(String height){this.height = height;}
    public String getWeight(){return weight;}
    public void setWeight(String weight){this.weight = weight;}
    public void setToken(String token){this.token = token;}
    public String getToken(){return token;}
    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public void setPwd(String pwd){this.pwd = pwd;}
    public String getPwd(){return pwd;}
    public static HashMap<String,User> userMap = new HashMap<>();
    public static User admin = new User("admin","123456","171cm","63kg");
    public static String sendSource(String sourceType,String username)
    {
        if(sourceType.equals("height"))
        {
            User temp = userMap.get(username);
            if(temp!=null)
            {
                return userMap.get(username).getHeight();
            }
            return "none";
        }
        if(sourceType.equals("weight"))
        {
            User temp = userMap.get(username);
            if(temp!=null)
            {
                return userMap.get(username).getWeight();
            }
            return "none";
        }
        return "none";
    }
    public static msg logout(String username)
    {
        User temp = userMap.get(username);
        msg ans = new msg();
        if(temp==null)
        {
            ans.code = 003;//001表示用户不存在
            ans.m = "退出登录:用户不存在！";
        }
        else
        {
            ans.code = 102;
            ans.m = "成功删除用户token";
            temp.setToken("");
        }
        return ans;
    }
    public static msg checkPwd(String username,String pwd)
    {
        User temp = userMap.get(username);
        msg ans = new msg();
        if(temp==null)
        {
            ans.code = 001;//001表示用户不存在
            ans.m = "用户不存在！";
        }
        else
        {
            if(pwd.equals(temp.getPwd()))
            {
                ans.code = 101;
                ans.m = "用户名密码匹配成功！";
            }
            else
            {
                ans.code = 002;
                ans.m = "密码错误！";
            }
        }
        return ans;
    }
}
