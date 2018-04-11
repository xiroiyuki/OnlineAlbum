package cn.fc.controller;

import cn.fc.bean.Photo;
import cn.fc.service.PhotoService;
import cn.fc.serviceImpl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("photo")
public class PhotoController {

    @Autowired
    private PhotoService service;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;

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
    public Map update(@Valid Photo photo, BindingResult result) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result);
        }
        return service.update(photo);
    }
}
