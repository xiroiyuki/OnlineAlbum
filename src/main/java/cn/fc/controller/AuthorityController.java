package cn.fc.controller;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.service.AuthorityService;
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
@RequestMapping("authority")
public class AuthorityController {

    @Autowired
    private AuthorityService service;
    @Autowired
    private RoleAuthorityService roleAuthorityService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        request.setAttribute("authority", service.getAuthority(id));
        return "authorityDetail";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("authorities", service.listAuthorities());
        return "authorityList";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        Authority authority = service.getAuthority(id);
        List<Role> has = roleAuthorityService.listRolesFromAuthority(authority);
        List<Role> notHas = roleAuthorityService.listExceptRolesFromAuthority(authority);
        request.setAttribute("authority", authority);
        request.setAttribute("has", has);
        request.setAttribute("notHas", notHas);
        return "authorityEdit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.deleteAuthority(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Authority authority, @RequestParam(value = "roleIds[]", required = false) Long[] roleIds) {
        roleAuthorityService.revokeAuthorityFromAllRoles(authority);
        if (roleIds != null && roleIds.length > 0) {
            roleAuthorityService.grantRolesToAuthority(roleIds, authority);
        }
        return service.updateAuthority(authority);
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        List<Role> roles = roleService.listRoles();
        request.setAttribute("roles", roles);
        return "authorityAdd";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Authority authority, @RequestParam(value = "roleIds[]", required = false) Long[] roleIds) {
        Map res = service.insertAuthority(authority);
        if (roleIds != null && roleIds.length > 0) {
            roleAuthorityService.grantRolesToAuthority(roleIds, authority);
        }
        return res;
    }

}
