package cn.fc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GateWay {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/workbench")
    public String workbench() {
        return "workbench";
    }


}
