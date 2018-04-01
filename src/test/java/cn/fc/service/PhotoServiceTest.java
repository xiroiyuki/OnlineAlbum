package cn.fc.service;

import cn.fc.bean.Photo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PhotoServiceTest {


    @Autowired
    PhotoService service;

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();


    @Test
    public void get() {
        long id = 1;
        Photo photo = service.get(id);
        System.out.println(gson.toJson(photo));
    }

    @Test
    public void getAllByAlbum() {
        List<Photo> photos = service.getAllByAlbum(1, 2);
        System.out.println(gson.toJson(photos));
    }

    @Test
    public void delete() {
        long id = 3;
        System.out.println(service.delete(id));
    }

    @Test
    public void update() {
        Photo photo = new Photo();
        photo.setId(4);
        photo.setAlbumId(2);
        photo.setUrl("2323");
        System.out.println(service.update(photo));
    }
}