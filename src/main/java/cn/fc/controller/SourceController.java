package cn.fc.controller;

import cn.fc.bean.Album;
import cn.fc.bean.Source;
import cn.fc.service.AlbumService;
import cn.fc.service.SourceService;
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
@RequestMapping("source")
public class SourceController {


    @Autowired
    private SourceService service;
    @Autowired
    private AlbumService albumService;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<Source> sources = service.getAllSource();
        request.setAttribute("sources", sources);
        return "sourceList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        Source source = service.get(id);
        List<Album> albums = albumService.getAllBySource(id);
        request.setAttribute("source", source);
        request.setAttribute("albums", albums);
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
    public Map update(@Valid Source sources, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        return service.update(sources);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
    }
}
