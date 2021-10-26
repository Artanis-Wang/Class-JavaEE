package server.demo.oauth2Server;


/**@author 王梓宇
 * @time 2021.10.19
 * 用户登出
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.User;
import server.demo.domain.msg;

import javax.servlet.http.HttpServletRequest;

@Controller
public class logout {
    @PostMapping(value="logout")
    public String logout(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        msg ans = User.logout(username);
        if (ans.code != 102) {
            System.out.println("Exception!用户不存在！");
        }
        return "redirect:http:localhost:8888/portal";
    }
}
