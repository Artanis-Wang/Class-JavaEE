package server.demo.domain;

import static server.demo.domain.User.userMap;
/**@author 王梓宇
 * @time 2021.10.18
 * 用于处理token相关内容的工具类
 */
public class Token {
    public static String createToken(String username)
    {
        String date = String.valueOf(System.currentTimeMillis());
        String token = date+username;
        User temp = userMap.get(username);
        temp.setToken(token);
        return token;
    }
    public static msg checkToken(String username,String token)
    {
        User temp = userMap.get(username);
        if(temp==null)
        {
            return new msg(003,"token错误，不存在该用户名！");
        }
        msg ans = new msg();
        if(temp.getToken().equals(token))
        {
            ans.code = 102;
            ans.m = "token匹配成功！";
        }
        else
        {
            ans.code = 004;
            ans.m = "token不匹配！";
        }
        return ans;
    }
}
