package cn.fc.controller;


import cn.fc.bean.Album;
import cn.fc.bean.Photo;
import cn.fc.service.AlbumService;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService service;
    @Autowired
    private PhotoService photoService;


    /**
     * 啥都不传 默认查询所有并显示第一页
     * 传page 和 source_id 可按来源选择
     *
     * @param request HttpServletRequest
     * @return 前端页面
     */
    @RequestMapping("/list")
    public String list(Integer page, HttpServletRequest request) {
        page = page == null ? 1 : page;
        List<Album> albums = service.getAll(page);
        request.setAttribute("albums", albums);
        request.setAttribute("page", page);
        return "albumList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, Integer page, HttpServletRequest request) {
        page = page == null ? 1 : page;
        if (id == null) {
            return "error";
        }
        Album album = service.get(id);
        List<Photo> photos = photoService.getAllByAlbum(id, page);
        request.setAttribute("photos", photos);
        request.setAttribute("album", album);
        request.setAttribute("page", page);
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
    public String delete(Long id) {
        if (id == null) {
            return "error";
        }
        boolean success = service.delete(id);
        if (success) {
            //TODO 重定向
            return "albumList";
        }
        return "error";
    }

    @RequestMapping("/update")
    public String update(Album album) {
        boolean success = service.update(album);
        if (success) {
            //TODO 重定向
            return "albumList";
        }
        return "error";
    }

}
