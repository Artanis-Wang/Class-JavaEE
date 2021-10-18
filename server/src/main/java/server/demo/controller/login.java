package server.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class login {
    @PostMapping(value = "loginHandle")
    public String loginHandle(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if(name.equals("admin")&&pwd.equals("123456"))
        {
            System.out.println("用户名，密码正确！");
            Date date = new Date();
            String token = "admin123456"+date.getTime();
            System.out.println("生成的token是："+token);
            User.admin.setToken(token);
            model.addAttribute("adminToken",token);
            return "sendToken";
        }
        return "loginError";
    }
}
