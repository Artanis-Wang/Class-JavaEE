package server.demo.oauth2Server;


/**@author 王梓宇
 * @time 2021.10.19
 * 使用密码登录的中转控制器
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginByPwd {
    @GetMapping(value = "loginByPwd")
    public String pwd(String redirectUrl, Model model)
    {
        model.addAttribute("redirectUrl",redirectUrl);
        return "loginByPwd";
    }
}
