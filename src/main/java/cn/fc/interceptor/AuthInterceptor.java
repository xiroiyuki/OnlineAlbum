package cn.fc.interceptor;

import cn.fc.bean.Authority;
import cn.fc.bean.User;
import cn.fc.dao.AuthorityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Authority> authorities = authorityDao.select();
        String path = request.getServletPath();
        System.out.println("visiting " + path);
        boolean match = authorities.stream().anyMatch(authority -> authority.getUrl().equals(path.trim()));
        if (match) {
            Object loginUser = request.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                response.sendRedirect("/login");
                return false;
            } else {
                User user = (User) loginUser;
                List<Authority> userAuthorities = user.getRole().getAuthorities();
                boolean grant = userAuthorities.stream().anyMatch(authority -> authority.getUrl().equals(path.trim()));
                if (grant) {
                    return true;
                } else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    request.setAttribute("errorCode", HttpServletResponse.SC_FORBIDDEN);
                    request.setAttribute("msg", "您没有权限访问,如有疑问请联系管理员");
                    request.getRequestDispatcher("/error").forward(request, response);
                    return false;
                }
            }
        }
        return true;
    }
}
