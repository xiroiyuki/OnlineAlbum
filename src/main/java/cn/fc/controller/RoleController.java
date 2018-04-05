package cn.fc.controller;

import cn.fc.bean.Role;
import cn.fc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private AuthService service;

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        request.setAttribute("role", service.getRole(id));
        return "roleDetail";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("roles", service.listRole());
        return "roleList";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        request.setAttribute("role", service.getRole(id));
        return "roleEdit";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.deleteRole(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Role role) {
        System.out.println(role);
        return service.updateRole(role);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Role role) {
        return service.insertRole(role);
    }


}
