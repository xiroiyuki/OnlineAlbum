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
public class RoleAuthorityDaoTest {


    @Autowired
    private RoleDao dao;
    @Autowired
    private RoleAuthorityDao raDao;
    @Autowired
    private AuthorityDao authorityDao;


    @Test
    public void insert() {
        Role role = dao.edit(1);
        Authority authority = authorityDao.selectId(1);
        RoleAuthority ra = new RoleAuthority();
        ra.setAuthority(authority);
        ra.setRole(role);
        raDao.insert(ra);
    }

    @Test
    public void deleteRole() {
        raDao.deleteRole(1);
    }

    @Test
    public void deleteAuthority() {
        Authority authority = authorityDao.selectId(1);
        raDao.deleteAuthority(authority.getId());
    }

    @Test
    public void selectRoleFromAuthority() {
        System.out.println(raDao.selectRoleFromAuthority(1));
    }

    @Test
    public void selectAuthorityFromRole() {
        System.out.println(raDao.selectAuthorityFromRole(2));

    }
}