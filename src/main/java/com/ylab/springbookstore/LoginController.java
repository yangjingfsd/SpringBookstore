package com.ylab.springbookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    
    @GetMapping("/accessdenied")
    public String showAccessDenied(){
        return "accessdenied";
    }
}
