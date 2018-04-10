package cn.fc.controller;

import cn.fc.bean.Role;
import cn.fc.bean.User;
import cn.fc.service.RoleService;
import cn.fc.service.UserService;
import cn.fc.serviceImpl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;


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
    public Map update(@Valid User user,Long roleId, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        Role role = roleService.getRole(roleId);
        user.setRole(role);
        return service.update(user);
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<User> users = service.listAll();
        request.setAttribute("users", users);
        return "userList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        User user = service.get(id);
        request.setAttribute("user", user);
        return "userDetail";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        User user = service.get(id);
        request.setAttribute("user", user);
        request.setAttribute("roles", roleService.listRoles());
        return "userEdit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
    }

}
