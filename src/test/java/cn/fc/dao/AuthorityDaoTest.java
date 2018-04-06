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
    private AuthorityDao dao;

    @Test
    public void selectExceptByIds() {
        System.out.println(dao.selectExceptByIds(new Long[]{1L, 2L, 3L}));
        System.out.println(dao.selectExceptByIds(new Long[]{1L, 2L, 3L, 4L, 5L, 6L}));
    }
}