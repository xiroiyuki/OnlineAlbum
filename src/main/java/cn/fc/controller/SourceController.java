package cn.fc.controller;

import cn.fc.bean.Album;
import cn.fc.bean.Source;
import cn.fc.service.AlbumService;
import cn.fc.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("source")
public class SourceController {


    @Autowired
    private SourceService service;
    @Autowired
    private AlbumService albumService;


    @RequestMapping("/list")
    public String list(Integer page, HttpServletRequest request) {
        page = page == null ? 1 : page;
        List<Source> sources;
        sources = service.getAllSource(page);
        request.setAttribute("sources", sources);
        request.setAttribute("page", page);
        return "sourceList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, Integer page, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        page = page == null ? 1 : page;
        Source source = service.get(id);
        List<Album> albums = albumService.getAllBySource(id, page);
        request.setAttribute("source", source);
        request.setAttribute("albums", albums);
        request.setAttribute("page", page);
        return "sourceDetail";
    }


    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        Source source = service.get(id);
        request.setAttribute("source", source);
        return "sourceEdit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Source sources) {
        return service.update(sources);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
    }
}
