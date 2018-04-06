package cn.fc.serviceImpl;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.service.AuthorityService;
import cn.fc.service.RoleAuthorityService;
import cn.fc.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AuthServiceImplTest {

    @Autowired
    RoleAuthorityService service;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthorityService authorityService;

    @Test
    public void listAuthoritiesFromRole() {
        Role role = roleService.getRole(5);
        System.out.println(service.listAuthoritiesFromRole(role));
    }

    @Test
    public void listRolesFromAuthority() {
        Authority authority = authorityService.getAuthority(1);
        System.out.println(service.listRolesFromAuthority(authority));
    }

    @Test
    public void listExceptAuthoritiesFromRole() {
        Role role = roleService.getRole(5);
        System.out.println(service.listExceptAuthoritiesFromRole(role));
    }

    @Test
    public void listExceptRolesFromAuthority() {
        Authority authority = authorityService.getAuthority(1);
        System.out.println(service.listExceptRolesFromAuthority(authority));

    }
}