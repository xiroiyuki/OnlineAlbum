package cn.fc.controller;


import cn.fc.bean.Album;
import cn.fc.bean.Photo;
import cn.fc.service.AlbumService;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService service;
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<Album> albums = service.getAll();
        request.setAttribute("albums", albums);
        return "albumList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        Album album = service.get(id);
        List<Photo> photos = photoService.getAllByAlbum(id);
        request.setAttribute("photos", photos);
        request.setAttribute("album", album);
        return "albumDetail";
    }

    /**
     * 编辑回显方法
     */
    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        Album album = service.get(id);
        request.setAttribute("album", album);
        return "albumEdit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Album album) {
        return service.update(album);
    }

}
