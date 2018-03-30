package cn.fc.controller;

import cn.fc.bean.User;
import cn.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    public String doLogin(String username, String password) {
        User user = service.login(username, password);
        if (user != null) {
            return "redirect:/workbench";
        }
        return "redirect:/";
    }

}
