package app2.demo.controller;


/**@author 钟祥新
 * @time 2021.10.18
 * 用于展示资源服务器发过来的资源
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class showSource {
    @PostMapping(value = "showSource")
    public String showSource(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String msg = request.getParameter("msg");
        // 如果资源服务器验证token成功则表面资源已发回，显示资源。
        if(msg.equals("true"))
        {
            String newToken = request.getParameter("newToken");
            String username = request.getParameter("username");
            if(!newToken.equals("-1"))
            {
                Cookie cookie =new Cookie("SSO"+username,newToken);
                //设置cookie一个月后过期
                cookie.setMaxAge(3600*24*30);
                response.addCookie(cookie);
            }
            String weight = request.getParameter("source");
            model.addAttribute("source",weight);
            model.addAttribute("username",username);
            return "showSource";
        }
        // token验证失败，转而通过oauth2认证服务器申请认证码code
        else
        {
            return "redirect:http://localhost:8080/loginByPwd?redirectUrl=http://localhost:8082/getCode";
        }
    }
}
