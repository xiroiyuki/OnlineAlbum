package cn.fc.dao;

import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;

public interface RoleAuthorityDao {
    void grant(RoleAuthority roleAuthority);

    void revoke(RoleAuthority roleAuthority);

    RoleAuthority exists(RoleAuthority roleAuthority);

    void revokeRole(Role role);

}
