package cn.fc.service;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AuthService {

    List<Role> listRole();

    List<Authority> listAuthority();

    Role getRole(long id);

    Authority getAuthority(long id);

    Map revoke(Role role, Authority authority);

    Map grant(Role role, Authority authority);

    List<Authority> loadLoginUserAuthority(User user);

    Map updateAuthority(Authority authority);

    Map updateRole(Role role);

    Map deleteRole(long id);

    Map deleteAuthority(long id);
}
