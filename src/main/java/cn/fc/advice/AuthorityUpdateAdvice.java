package cn.fc.advice;

import cn.fc.context.AlbumContext;
import cn.fc.dao.AuthorityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityUpdateAdvice {
    @Autowired
    private AlbumContext context;
    @Autowired
    private AuthorityDao authorityDao;

    public void after() {
        context.setAuthorities(authorityDao.select());
    }
}
