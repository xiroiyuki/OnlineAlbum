package cn.fc.service;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AuthServiceTest {


    @Autowired
    private AuthService service;

    @Test
    public void listRole() {
        System.out.println(service.listRole());
    }

    @Test
    public void listAuthority() {
        System.out.println(service.listAuthority());
    }

    @Test
    public void getRole() {
        System.out.println(service.getRole(5));
    }

    @Test
    public void getAuthority() {
        System.out.println(service.getAuthority(4));
    }

    @Test
    public void revoke() {
        Authority authority = service.getAuthority(1);
        Role role = service.getRole(1);
        System.out.println(service.revoke(role, authority));
    }

    @Test
    public void grant() {
        Authority authority = service.getAuthority(2);
        Role role = service.getRole(2);
        System.out.println(service.grant(role, authority));
    }

    @Test
    public void loadLoginUserAuthority() {
    }

    @Test
    public void updateAuthority() {
        Authority authority = service.getAuthority(2);
        authority.setName("201804051134");
        authority.setUrl("/201804051134");
        System.out.println(service.updateAuthority(authority));
    }

    @Test
    public void updateRole() {
        Role role = service.getRole(4);
        role.setRoleName("201804051135");
        service.updateRole(role);
    }

    @Test
    public void deleteRole() {
        System.out.println(service.deleteRole(3));
    }

    @Test
    public void deleteAuthority() {
        System.out.println(service.deleteAuthority(4));
    }

    @Test
    public void insertAuthority() {
        Authority authority = new Authority();
        authority.setName("n_201804051134");
        authority.setUrl("/n_201804051134");
        System.out.println(service.insertAuthority(authority));
    }

    @Test
    public void insertRole() {
        Role role = new Role();
        role.setRoleName("201804051135");
        System.out.println(service.insertRole(role));
    }
}