package cn.fc.service;

import cn.fc.bean.Album;
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
public class AlbumServiceTest {

    @Autowired
    AlbumService albumService;


    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();


    @Test
    public void get() {
        long id = 3;
        Album album = albumService.get(id);
        System.out.println(gson.toJson(album));
    }

    @Test
    public void getAllBySource() {
        long sourceId = 1;
        List<Album> albums = albumService.getAllBySource(sourceId, 1);
        System.out.println(gson.toJson(albums));

    }

    @Test
    public void delete() {
        long id = 4;
        boolean success = albumService.delete(id);
        System.out.println(success);

    }

    @Test
    public void update() {
        Album album = new Album();
        album.setId(10);
        album.setTitle("7");
        album.setCreateTime(3);
        album.setIntro("2");
        album.setFaceUrl("4");
        album.setPhotoNum(23);
        album.setUrl("8");
        album.setCreateTime(13);
        album.setSourceId(3);
        albumService.update(album);
    }
}