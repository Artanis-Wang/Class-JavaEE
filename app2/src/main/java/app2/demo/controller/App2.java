package app2.demo.controller;

/**@author 钟祥新
 * @time 2021.10.18
 * 客户端申请资源
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class App2 {
    @RequestMapping(value = "app2")
    public String app1(HttpServletRequest request, Model model)
    {
        String username = "";
        String token ="";
        String redirectUrl = "http://localhost:8082/showSource";
        //如果有token则直接发送token获取资源
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("SSO")) {
                    // 获取token
                    token = cookie.getValue();
                    // 获取用户名
                    username = cookie.getName().substring(3);
                    model.addAttribute("username",username);
                    model.addAttribute("token",token);
                    model.addAttribute("redirectUrl",redirectUrl);
                    model.addAttribute("sourceType","weight");
                    return "sendToken";
                }
            }
        }
        // 如果没有token则通过oauth服务器申请认证码
        return "redirect:http://localhost:8080/loginByPwd?redirectUrl=http://localhost:8082/getCode";
    }
}
