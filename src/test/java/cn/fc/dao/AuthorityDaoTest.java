package cn.fc.dao;

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

    @Test
    public void insert() {


    }

    @Test
    public void delete() {
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
    }

    @Test
    public void update() {
    }
}