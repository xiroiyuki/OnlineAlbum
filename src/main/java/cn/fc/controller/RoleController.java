package cn.fc.controller;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
        Role role = service.getRole(id);
        List<Authority> has = service.listRoleAuthority(role);
        List<Authority> notHas = service.listRoleNotHasAuthority(role);
        System.out.println(has);
        System.out.println(notHas);
        request.setAttribute("role", role);
        request.setAttribute("has", has);
        request.setAttribute("notHas", notHas);
        return "roleEdit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.deleteRole(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Role role, @RequestParam(value = "authorityIds[]", required = false) Long[] authorityIds) {
        service.revokeRole(role);
        if (authorityIds != null && authorityIds.length > 0) {
            service.grantList(role, authorityIds);
        }
        return service.updateRole(role);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Role role) {
        return service.insertRole(role);
    }


}
