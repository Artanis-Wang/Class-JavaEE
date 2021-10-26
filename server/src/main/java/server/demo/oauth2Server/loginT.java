package server.demo.oauth2Server;


/**@author 王梓宇
 * @time 2021.10.19
 * 验证token的正确性
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.Token;
import server.demo.domain.User;
import server.demo.domain.msg;
import server.demo.domain.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginT {
    @PostMapping(value = "loginByToken")
    public String loginHandle(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String token = security.decrypt(request.getParameter("token"));
        String newToken = "-1";
        // 获取验证token的消息体
        msg ans = Token.checkToken(username,token);
        System.out.println("loginT ans.m"+ans.m);
        String Msg = "False";
        String sourceRedirectUrl = request.getParameter("sourceRedirectUrl");
        // 如果token匹配成功
        if(ans.code==102)
        {
            Msg = "true";
            long now = System.currentTimeMillis();
            long tokenTime = Long.parseLong(token.substring(0, 13));
            // 如果token快要过期了，重新签发一个
            if((now-tokenTime)/1000>3600*600)
            {
                System.out.println("token重新签发");
                newToken = Token.createToken(username);
            }
        }
        String sourceType = request.getParameter("sourceType");
        model.addAttribute("msg",Msg);
        model.addAttribute("sourceType",sourceType);
        model.addAttribute("username",username);
        model.addAttribute("redirectUrl",redirectUrl);
        model.addAttribute("newToken",newToken);
        model.addAttribute("sourceRedirectUrl",sourceRedirectUrl);
        return "sendMsg";
    }
}
