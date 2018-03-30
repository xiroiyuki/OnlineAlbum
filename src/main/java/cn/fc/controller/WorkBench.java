package cn.fc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workbench")
public class WorkBench {


    @RequestMapping
    public String workbench(){
        return "workbench";
    }



}
