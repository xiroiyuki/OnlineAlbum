package cn.fc.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorCode", HttpServletResponse.SC_NOT_FOUND);
        mv.addObject("msg", "请求的资源不存在");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return mv;
    }

}
