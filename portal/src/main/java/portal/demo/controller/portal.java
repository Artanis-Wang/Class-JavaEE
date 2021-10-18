package portal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class portal {
    @RequestMapping(value = "portal")
    public String getPortal()
    {
        return "portal";
    }
}
