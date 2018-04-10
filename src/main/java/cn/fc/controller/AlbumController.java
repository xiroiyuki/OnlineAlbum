package cn.fc.controller;


import cn.fc.bean.Album;
import cn.fc.bean.Photo;
import cn.fc.service.AlbumService;
import cn.fc.service.PhotoService;
import cn.fc.serviceImpl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService service;
    @Autowired
    private PhotoService photoService;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;


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
    public Map update(@Valid Album album, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        return service.update(album);
    }

    @RequestMapping("/refresh")
    @ResponseBody
    public Map refresh(Long albumId) {
        return service.refresh(albumId);
    }

}
