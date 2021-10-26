package server.demo.sourceServer;


/**@author 王梓宇
 * @time 2021.10.20
 * 资源服务器接收，验证子系统发来的token
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GetToken {
    @PostMapping(value = "getToken")
    public String sendSource(HttpServletRequest request, Model model)
    {
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String token = request.getParameter("token");
        String sourceType = request.getParameter("sourceType");
        String sourceRedirectUrl = "http://localhost:8080/sendSource";
        model.addAttribute("token",token);
        model.addAttribute("sourceRedirectUrl",sourceRedirectUrl);
        model.addAttribute("redirectUrl",redirectUrl);
        model.addAttribute("username",username);
        model.addAttribute("sourceType",sourceType);
        return "checkToken";
    }
}
