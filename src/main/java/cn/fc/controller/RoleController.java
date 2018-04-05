package cn.fc.controller;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.service.RoleAuthorityService;
import cn.fc.service.RoleService;
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
    private RoleService service;
    @Autowired
    private RoleAuthorityService roleAuthorityService;

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
        List<Authority> has = roleAuthorityService.listAuthoritiesFromRole(role);
        List<Authority> notHas = roleAuthorityService.listExceptAuthoritiesFromRole(role);
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
        roleAuthorityService.revokeRoleFromAllAuthorities(role);
        if (authorityIds != null && authorityIds.length > 0) {
            roleAuthorityService.grantAuthoritiesToRole(authorityIds, role);
        }
        return service.updateRole(role);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Role role) {
        return service.insertRole(role);
    }


}
