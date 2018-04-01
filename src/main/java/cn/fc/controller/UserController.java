package cn.fc.controller;

import cn.fc.bean.User;
import cn.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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


    @RequestMapping("/update")
    @ResponseBody
    public Map update(User user) {
        return service.update(user);
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<User> users = service.listAll();
        request.setAttribute("users", users);
        return "userList";
    }

}
