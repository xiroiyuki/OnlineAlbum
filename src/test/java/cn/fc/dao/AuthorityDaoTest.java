package cn.fc.dao;

import cn.fc.bean.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AuthorityDaoTest {


    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {

        Authority authority = new Authority();
        authority.setUrl("tetteee");
        authority.setName("tetetaw");
        authorityDao.insert(authority);

    }

    @Test
    public void delete() {
        authorityDao.delete(5);
    }

    @Test
    public void select() {
        System.out.println(authorityDao.select());
    }

    @Test
    public void selectById() {
        System.out.println(authorityDao.selectById(1L).getRoles());

    }

    @Test
    public void loadUserAuthority() {
        System.out.println(authorityDao.loadUserAuthority(userDao.selectById(4)));
    }

    @Test
    public void update() {
        Authority authority = authorityDao.selectById(5);
        authority.setName("81823482348");
        authorityDao.update(authority);
    }
}