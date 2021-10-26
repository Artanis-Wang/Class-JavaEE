package server.demo.oauth2Server;


/**@author 王梓宇
 * @time 2021.10.19
 * 检查app端发来的认证码code
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.Token;
import server.demo.domain.User;
import server.demo.domain.security;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkCode {
    @PostMapping(value = "checkCode")
    public String chekCode(HttpServletRequest request, Model model)
    {
        //code解密
        String code = security.decrypt(request.getParameter("code"));
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String checkUsername = User.userMap.get(username).getUsername();
        if(code.equals(checkUsername))
        {
            String token = Token.createToken(username);
            model.addAttribute("token",security.encrypt(token));
            model.addAttribute("redirectUrl",redirectUrl);
            model.addAttribute("username",username);
            return "sendToken";
        }
        return "redirect://localhost:8888/portal";
    }
}
