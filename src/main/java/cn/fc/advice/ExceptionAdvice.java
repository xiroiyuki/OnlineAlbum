package cn.fc.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorCode", 500);
        mv.addObject("msg", "请求错误");
        return mv;
    }

}
