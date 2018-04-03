package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AuthorityDaoTest {


    @Autowired
    private AuthorityDao dao;

    @Test
    public void insert() {
        Authority authority = new Authority();
        authority.setName("测试人员");
        authority.setUrl("/test/url");
        dao.insert(authority);
    }

    @Test
    public void delete() {
        dao.delete(1);
        dao.delete(2);

    }

    @Test
    public void select() {
        System.out.println(dao.select());
    }

    @Test
    public void selectId() {
        System.out.println(dao.selectId(1L));
    }

    @Test
    public void loadUserAuthority() {
        User user = new User();
        user.setId(4);
        System.out.println(dao.loadUserAuthority(user));

    }

    @Test
    public void update() {
        Authority authority = dao.selectId(1L);
        authority.setUrl("url/test");
        dao.update(authority);
    }
}