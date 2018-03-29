package cn.fc.dao;

import cn.fc.bean.Source;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SourceDaoTest {


    @Autowired
    private SourceDao dao;

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();

    @Test
    public void select() {
        List<Source> list = dao.select();
        for (Source source : list) {
            System.out.println(gson.toJson(source));
        }
    }

    @Test
    public void update() {
        Source source = new Source();
        source.setId(2);
        source.setName("ccc");
        dao.update(source);

    }
}