package cn.fc.interceptor;

import cn.fc.bean.Authority;
import cn.fc.bean.Log;
import cn.fc.bean.User;
import cn.fc.context.AlbumContext;
import cn.fc.service.AuthorityService;
import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

public class LogInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private LogService logService;
    @Autowired
    private AlbumContext context;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (context.getAuthorities() == null) {
            context.setAuthorities(authorityService.listAuthorities());
        }
        List<Authority> authorities = context.getAuthorities();
        String path = request.getServletPath();
        List<Authority> matches = authorities.stream().
                filter(authority -> authority.getUrl().equals(path)).
                limit(1).
                collect(Collectors.toList());
        if (!matches.isEmpty()) {
            Object obj = request.getSession().getAttribute("loginUser");
            User loginUser;
            Log log = new Log();
            if (obj != null) {
                loginUser = (User) obj;
                log.setUser(loginUser);
            }
            log.setMethod(request.getMethod());
            log.setAuthority(matches.get(0));
            log.setReqTime(System.currentTimeMillis() / 1000);
            logService.saveLog(log);
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
