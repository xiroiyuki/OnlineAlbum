package cn.fc.controller;

import cn.fc.bean.Photo;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
        boolean success = service.delete(id);
        Map<String, Object> res = new HashMap<>();
        res.put("result", success);
        if (success) {
            res.put("code", 200);
            res.put("msg", "删除成功");
            return res;
        }
        res.put("code", 500);
        res.put("msg", "删除失败");
        return res;
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
        boolean success = service.update(photo);
        Map<String, Object> res = new HashMap<>();
        res.put("result", success);
        if (success) {
            res.put("code", 200);
            res.put("msg", "更新成功");
            return res;
        }
        res.put("code", 500);
        res.put("msg", "操作失败");
        return res;
    }
}
