package cn.fc.service;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.User;

import java.util.List;
import java.util.Map;

public interface AuthService {

    List<Role> listRole();

    List<Authority> listAuthority();

    List<Authority> listRoleAuthority(Role role);

    List<Authority> listAuthorityRole(Authority authority);

    List<Authority> listRoleNotHasAuthority(Role role);

    List<Authority> listAuthorityNotHasRole(Authority authority);

    Role getRole(long id);

    Authority getAuthority(long id);

    void revokeRole(Role role);

    void revokeAuthority(Authority authority);

    void grantAuthorities(Role role, Long[] authorityIds);

    void grantRoles(Long[] roleIds, Authority authority);

    List<Authority> loadLoginUserAuthority(User user);

    Map updateAuthority(Authority authority);

    Map updateRole(Role role);

    Map deleteRole(long id);

    Map deleteAuthority(long id);

    Map insertAuthority(Authority authority);

    Map insertRole(Role role);


}
