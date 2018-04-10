package cn.fc.controller;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.service.AuthorityService;
import cn.fc.service.RoleAuthorityService;
import cn.fc.service.RoleService;
import cn.fc.serviceImpl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;


    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        request.setAttribute("authority", service.getAuthority(id));
        return "authorityDetail";
    }

    @RequestMapping("/detail.json")
    @ResponseBody
    public Map detailJson(@RequestParam(value = "authorityIds[]", required = false) Long[] authorityIds) {
        if (authorityIds != null && authorityIds.length > 0) {
            return service.listAuthoritiesByIds(authorityIds);
        } else {
            return service.listAuthoritiesByIds(new Long[]{});
        }
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
    public Map update(@Valid Authority authority, @RequestParam(value = "roleIds[]", required = false) Long[] roleIds, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
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
    public Map insert(@Valid Authority authority, @RequestParam(value = "roleIds[]", required = false) Long[] roleIds, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        Map res = service.insertAuthority(authority);
        if (roleIds != null && roleIds.length > 0) {
            roleAuthorityService.grantRolesToAuthority(roleIds, authority);
        }
        return res;
    }

}
