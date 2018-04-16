package cn.fc.serviceImpl;

import cn.fc.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LogServiceImplTest {


    @Autowired
    private LogService service;

    @Test
    public void listCountsGroupByHour() {
        System.out.println(service.listCountsGroupByHour());
    }

    @Test
    public void listCountsGroupByMonth() {
        System.out.println(service.listCountsGroupByMonth());
    }

    @Test
    public void listCountsGroupByWeekday() {
        System.out.println(service.listCountsGroupByWeekday());
    }
}