package cn.fc.controller;

import cn.fc.bean.Authority;
import cn.fc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("authority")
public class AuthorityController {

    @Autowired
    private AuthService service;

    @RequestMapping("/detail")
    public String detail(Long id, HttpServletRequest request) {
        request.setAttribute("authority", service.getAuthority(id));
        return "authorityDetail";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("authorities", service.listAuthority());
        return "authorityList";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        request.setAttribute("authority", service.getAuthority(id));
        return "authorityEdit";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Long id) {
        return service.deleteAuthority(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Authority authority) {
        return service.updateAuthority(authority);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Authority authority) {
        return service.insertAuthority(authority);
    }


}
