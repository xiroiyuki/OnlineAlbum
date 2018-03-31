package cn.fc.controller;

import cn.fc.bean.User;
import cn.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    public String doLogin(String username, String password, HttpSession session) {
        User user = service.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/workbench";
        }
        return "redirect:/";
    }

}
