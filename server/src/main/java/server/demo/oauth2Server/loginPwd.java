package server.demo.oauth2Server;


/**@author 王梓宇
 * @time 2021.10.19
 * 密码登录逻辑处理
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.User;
import server.demo.domain.msg;
import server.demo.domain.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginPwd {
    @PostMapping(value = "loginPwd")
    public String loginPwd(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        msg ans = User.checkPwd(username,pwd);
        if(ans.code==101)
        {
              String code = username;
              model.addAttribute("code", security.encrypt(code));
              model.addAttribute("username",username);
              model.addAttribute("redirectUrl",redirectUrl);
              return "sendCode";
        }
        model.addAttribute("redirectUrl",redirectUrl);
        model.addAttribute("exceptionMsg",ans.m);
        return "loginError";
    }
}
