package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;

import java.util.List;

public interface RoleAuthorityDao {
    void grant(RoleAuthority roleAuthority);

    void grantAll(List<RoleAuthority> roleAuthorities);

    void revoke(RoleAuthority roleAuthority);

    RoleAuthority exists(RoleAuthority roleAuthority);

    void revokeRole(Role role);

    void revokeAuthority(Authority authority);

}
