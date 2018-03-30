package cn.fc.controller;

import cn.fc.bean.Source;
import cn.fc.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/source")
public class SourceController {


    @Autowired
    private SourceService service;

    @RequestMapping("/list")
    public String list(Integer page, HttpServletRequest request) {
        page = page == null ? 1 : page;
        List<Source> sources;
        sources = service.getAllSource(page);
        request.setAttribute("sources", sources);
        return "sourceList";
    }


    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        if (id == null) {
            return "error";
        }
        Source source = service.get(id);
        request.setAttribute("source", source);
        return "sourceList";
    }

    @RequestMapping("/update")
    public String update(Source sources) {
        boolean success = service.update(sources);
        if (success) {
            return "sourceList";
        }
        return "error";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id == null) {
            return "error";
        }
        boolean success = service.delete(id);
        if (success) {
            return "sourceList";
        }
        return "error";
    }
}
