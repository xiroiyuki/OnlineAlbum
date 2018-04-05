package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;

import java.util.List;

public interface RoleAuthorityDao {
    void grantRoleAuthorities(List<RoleAuthority> roleAuthorities);

    void revokeRole(Role role);

    void revokeAuthority(Authority authority);

}
