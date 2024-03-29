package cn.fc.interceptor;

import cn.fc.bean.Authority;
import cn.fc.bean.User;
import cn.fc.context.AlbumContext;
import cn.fc.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private AlbumContext context;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (context.isDevMode()) {
            return true;
        }
        if (context.getAuthorities() == null) {
            context.setAuthorities(authorityService.listAuthorities());
        }
        List<Authority> authorities = context.getAuthorities();
        String path = request.getServletPath();
        boolean match = authorities.stream().anyMatch(authority -> authority.getUrl().equals(path.trim()));
        if (match) {
            User user = (User) request.getSession().getAttribute("loginUser");
            List<Authority> userAuthorities = user.getRole().getAuthorities();
            boolean grant = userAuthorities.stream().anyMatch(authority -> authority.getUrl().equals(path.trim()));
            request.setAttribute("grant", grant);
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
        return true;
    }
}
