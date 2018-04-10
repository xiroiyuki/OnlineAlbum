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
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService service;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RoleAuthorityService roleAuthorityService;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;


    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        request.setAttribute("role", service.getRole(id));
        return "roleDetail";
    }

    @RequestMapping("/detail.json")
    @ResponseBody
    public Map detailJson(Long id) {
        return baseService.createOKResultMap(service.getRole(id));
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("roles", service.listRoles());
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
    public Map update(@Valid Role role, @RequestParam(value = "authorityIds[]", required = false) Long[] authorityIds, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        roleAuthorityService.revokeRoleFromAllAuthorities(role);
        if (authorityIds != null && authorityIds.length > 0) {
            roleAuthorityService.grantAuthoritiesToRole(authorityIds, role);
        }
        return service.updateRole(role);
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        List<Authority> authorities = authorityService.listAuthorities();
        request.setAttribute("authorities", authorities);
        return "roleAdd";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(@Valid Role role, @RequestParam(value = "authorityIds[]", required = false) Long[] authorityIds, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        Map res = service.insertRole(role);
        if (authorityIds != null && authorityIds.length > 0) {
            roleAuthorityService.grantAuthoritiesToRole(authorityIds, role);
        }
        return res;
    }


}
