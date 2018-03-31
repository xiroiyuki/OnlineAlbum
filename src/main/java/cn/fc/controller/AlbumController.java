package cn.fc.controller;


import cn.fc.bean.Album;
import cn.fc.service.AlbumService;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 啥都不传 默认查询所有并显示第一页
     * 传page 和 source_id 可按来源选择
     *
     * @param request HttpServletRequest
     * @return 前端页面
     */
    @RequestMapping("/list")
    public String list(Integer page, Long sourceId, HttpServletRequest request) {
        page = page == null ? 1 : page;
        if (sourceId == null) {
            return "error";
        }
        List<Album> albums = service.getAllBySource(sourceId, page);
        request.setAttribute("albums", albums);
        request.setAttribute("page", page);
        request.setAttribute("sourceId", sourceId);
        return "albumList";
    }

    @RequestMapping("/listAll")
    public String list(Integer page, HttpServletRequest request) {
        page = page == null ? 1 : page;
        List<Album> albums = service.getAll(page);
        System.out.println(albums);
        request.setAttribute("albums", albums);
        request.setAttribute("page", page);
        return "albumListAll";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        if (StringUtils.isNumeric(id)) {
            long id_ = Long.valueOf(id);
            Album album = service.get(id_);
            request.setAttribute("album", album);
        }
        return "albumEdit";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id == null) {
            return "error";
        }
        boolean success = service.delete(id);
        if (success) {
            return "albumList";
        }
        return "error";
    }

    @RequestMapping("/update")
    public String update(Album album) {
        boolean success = service.update(album);
        if (success) {
            return "albumList";
        }
        return "error";
    }

}
