package cn.fc.controller;

import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService service;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("logList");
        modelAndView.addObject("logs", service.listLogs());
        return modelAndView;
    }

    @RequestMapping("/clear")
    @ResponseBody
    public Map clear() {
        return service.clear();
    }
}
