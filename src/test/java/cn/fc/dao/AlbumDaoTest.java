package cn.fc.dao;

import cn.fc.bean.Album;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AlbumDaoTest {
    @Autowired
    private AlbumDao albumDao;

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.setPrettyPrinting().create();

    @Test
    public void selectAll() {
        List<Album> albums = albumDao.selectAll();
        for (Album album : albums) {
            System.out.println(gson.toJson(album));
        }
    }

    @Test
    public void selectBySource() {
        List<Album> albums = albumDao.selectBySource(1L);
        for (Album album : albums) {
            System.out.println(gson.toJson(album));
        }
    }

    @Test
    public void selectBySource1() {
        List<Album> albums = albumDao.selectBySource(1L, 2, 1);
        for (Album album : albums) {
            System.out.println(gson.toJson(album));
        }
    }

    @Test
    public void delete() {
        albumDao.delete(136);
    }

    @Test
    public void update() {
        Album album = new Album();
        album.setId(137);
        album.setTitle("7");
        album.setCreateTime(3);
        album.setIntro("2");
        album.setFaceUrl("4");
        album.setPhotoNum(23);
        album.setUrl("8");
        album.setCreateTime(13);
        album.setSourceId(3);
        albumDao.update(album);
    }
}