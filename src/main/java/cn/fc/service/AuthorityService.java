package cn.fc.service;

import cn.fc.bean.Authority;

import java.util.List;
import java.util.Map;

public interface AuthorityService {
    List<Authority> listAuthorities();

    Authority getAuthority(long id);

    Map listAuthoritiesByIds(Long[] authorityIds);

    Map updateAuthority(Authority authority);

    Map deleteAuthority(long id);

    Map insertAuthority(Authority authority);

}
