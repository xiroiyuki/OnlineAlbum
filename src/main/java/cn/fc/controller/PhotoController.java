package cn.fc.controller;

import cn.fc.bean.Photo;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("photo")
public class PhotoController {

    @Autowired
    private PhotoService service;

    @RequestMapping("/list")
    public String list(Integer page, Long albumId, HttpServletRequest request) {
        page = page == null ? 1 : page;
        if (albumId == null) {
            return "error";
        }
        List<Photo> photos = service.getAllByAlbum(albumId, page);
        request.setAttribute("photos", photos);
        request.setAttribute("page", page);
        request.setAttribute("albumId", albumId);
        return "photoList";
    }


    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        Photo photo = service.get(id);
        request.setAttribute("photo", photo);
        return "photoDetail";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id == null) {
            return "error";
        }
        boolean success = service.delete(id);
        if (success) {
            return "redirect:listAll";
        }
        return "error";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        Photo photo = service.get(id);
        request.setAttribute("photo", photo);
        return "photoEdit";
    }

    @RequestMapping("/update")
    public String update(Photo photo) {
        boolean success = service.update(photo);
        if (success) {
            return "redirect:listAll";
        }
        return "error";
    }
}
