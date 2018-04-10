package cn.fc.service;

import cn.fc.bean.Authority;
import cn.fc.bean.User;

import java.util.List;
import java.util.Map;

public interface AuthorityService {
    List<Authority> listAuthorities();

    Authority getAuthority(long id);

    List<Authority> loadLoginUserAuthority(User user);

    Map listAuthoritiesByIds(Long[] authorityIds);

    Map updateAuthority(Authority authority);

    Map deleteAuthority(long id);

    Map insertAuthority(Authority authority);

}
