package cn.fc.controller;

import cn.fc.bean.Photo;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("photo")
public class PhotoController {

    @Autowired
    private PhotoService service;

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
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
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
    @ResponseBody
    public Map update(Photo photo) {
        return service.update(photo);
    }
}
