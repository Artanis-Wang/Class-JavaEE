package app2.demo.controller;


/**@author 钟祥新
 * @time 2021.10.18
 * 用户处理oauth2认证服务器发过来的token
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class getToken {
    @PostMapping(value = "getToken")
    public String getToken(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String username = request.getParameter("username");
        String token = request.getParameter("token");
        String redirectUrl = "http://localhost:8082/showSource";
        String sourceType = "weight";
        Cookie cookie =new Cookie("SSO"+username,token);
        //把token存在本地，并设置cookie一个月后过期
        cookie.setMaxAge(3600*24*30);
        response.addCookie(cookie);
        model.addAttribute("username",username);
        model.addAttribute("token",token);
        model.addAttribute("redirectUrl",redirectUrl);
        model.addAttribute("sourceType",sourceType);
        return "sendToken";
    }
}
