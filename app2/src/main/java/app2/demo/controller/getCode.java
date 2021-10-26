package app2.demo.controller;


/**@author 钟祥新
 * @time 2021.10.18
 * 用户处理oauth2认证服务器发过来的认证码
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class getCode {
    @PostMapping(value = "getCode")
    public String getCode(HttpServletRequest request, Model model)
    {
        String username = request.getParameter("username");
        String code = request.getParameter("code");
        String redirectUrl = "http://localhost:8082/getToken";
        model.addAttribute("username",username);

        model.addAttribute("code",code);
        model.addAttribute("redirectUrl",redirectUrl);
        return "sendCode";
    }
}
