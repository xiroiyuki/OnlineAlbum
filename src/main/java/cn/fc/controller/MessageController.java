package cn.fc.controller;

import cn.fc.bean.Message;
import cn.fc.service.MsgService;
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
import java.util.Map;

@RequestMapping("message")
@Controller
public class MessageController {
    @Autowired
    private MsgService service;
    @Qualifier("baseService")
    @Autowired
    private BaseService baseService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("msgs", service.listMessages());
        return "msgList";
    }

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        Message message = service.getMessage(id);
        request.setAttribute("msg", message);
        return "msgDetail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.delete(id);
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        Message message = service.getMessage(id);
        request.setAttribute("msg", message);
        return "msgEdit";
    }

    @RequestMapping("/add")
    public String add() {
        return "msgAdd";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(@Valid Message message, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        return service.update(message);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(@Valid Message message, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return baseService.errorHandler(result, response);
        }
        return service.insert(message);
    }

}
