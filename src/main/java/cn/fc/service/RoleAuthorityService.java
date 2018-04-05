package cn.fc.service;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;

import java.util.List;

public interface RoleAuthorityService {

    List<Authority> listAuthoritiesFromRole(Role role);

    List<Role> listRolesFromAuthority(Authority authority);

    List<Authority> listExceptAuthoritiesFromRole(Role role);

    List<Role> listExceptRolesFromAuthority(Authority authority);

    void revokeRoleFromAllAuthorities(Role role);

    void revokeAuthorityFromAllRoles(Authority authority);

    void grantAuthoritiesToRole(Long[] authorityIds, Role role);

    void grantRolesToAuthority(Long[] roleIds, Authority authority);

}
