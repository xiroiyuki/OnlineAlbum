package cn.fc.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (path.contains("login")) {
            return true;
        }
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
