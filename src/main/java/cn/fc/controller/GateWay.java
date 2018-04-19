package cn.fc.controller;


import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GateWay {


    @Autowired
    private LogService service;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("weekly", service.listCountsGroupByWeekday());
        mv.addObject("daily", service.listCountsGroupByHour());
        mv.addObject("monthly", service.listCountsGroupByMonthDay());
        return mv;
    }

    @RequestMapping("/workbench")
    public String workbench() {
        return "workbench";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

}
