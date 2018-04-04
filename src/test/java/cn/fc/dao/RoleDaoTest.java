package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RoleDaoTest {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AuthorityDao authorityDao;


    @Test
    public void grant() {
        Role role = roleDao.selectById(1);
        Authority authority = authorityDao.selectById(1);
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRole(role);
        roleAuthority.setAuthority(authority);
        roleAuthorityDao.grant(roleAuthority);
    }

    @Test
    public void revoke() {
        Role role = roleDao.selectById(1);
        Authority authority = authorityDao.selectById(1);
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRole(role);
        roleAuthority.setAuthority(authority);

        roleAuthorityDao.revoke(roleAuthority);
    }

    @Test
    public void insert() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void select() {
        System.out.println(roleDao.select());
    }

    @Test
    public void selectById() {
        System.out.println(roleDao.selectById(2).getAuthorities());
    }

    @Test
    public void update() {
    }
}