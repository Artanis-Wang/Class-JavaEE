package server.demo.sourceServer;


/**@author 王梓宇
 * @time 2021.10.20
 * 处理oauth2认证服务器对token的验证结果，如果token正确则发送资源。
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class sendSource {
    @PostMapping(value = "sendSource")
    public String sendSource(HttpServletRequest request, Model model)
    {
        String msg = request.getParameter("msg");
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String source = "";
        String newToken = "";
        if(msg.equals("true"))
        {
            String sourceType = request.getParameter("sourceType");
            newToken = request.getParameter("newToken");
            // 提取资源
            source = User.sendSource(sourceType,username);
        }
        model.addAttribute("msg",msg);
        model.addAttribute("redirectUrl",redirectUrl);

        model.addAttribute("username",username);
        model.addAttribute("source",source);
        model.addAttribute("newToken",newToken);

        return "sendSource";
    }
}
