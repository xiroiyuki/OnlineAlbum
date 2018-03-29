package cn.fc.dao;

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
public class PhotoDaoTest {


    @Autowired
    private PhotoDao dao;
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();

    @Test
    public void selectAll() {
        List<Photo> photos = dao.selectAll();
        for (Photo photo : photos) {
            System.out.println(gson.toJson(photo));
        }
    }

    @Test
    public void selectByAlbumId() {
        List<Photo> photos = dao.selectByAlbumId(1);
        for (Photo photo : photos) {
            System.out.println(gson.toJson(photo));
        }
    }

    @Test
    public void delete() {
        dao.delete(2);
    }

    @Test
    public void update() {
        Photo photo = new Photo();
        photo.setId(3);
        photo.setAlbumId(2);
        photo.setUrl("2323");
        dao.update(photo);
    }
}