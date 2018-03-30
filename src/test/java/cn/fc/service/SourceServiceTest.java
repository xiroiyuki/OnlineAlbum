package cn.fc.service;

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
public class SourceServiceTest {


//    @Autowired
    SourceService sourceService;

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();


    @Test
    public void get() {
        long id = 1;
        Source source = sourceService.get(id);
        System.out.println(gson.toJson(source));
    }

    @Test
    public void getAllSource() {
        List<Source> sources = sourceService.getAllSource(2);
        System.out.println(gson.toJson(sources));

    }

    @Test
    public void update() {
        Source source = new Source();
        source.setId(2);
        source.setName("ccc");
        boolean success = sourceService.update(source);
        System.out.println(success);
    }

    @Test
    public void delete() {
        long id = 3;
        boolean success = sourceService.delete(id);
        System.out.println(success);
    }
}