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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Album album) {
        service.update(album);
        Map<String, Object> res = new HashMap<>();
        res.put("result", true);
        res.put("code", 200);
        res.put("msg", "更新成功");
        return res;
    }

}
