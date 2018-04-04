package cn.fc.dao;

import cn.fc.bean.RoleAuthority;

public interface RoleAuthorityDao {
    void grant(RoleAuthority roleAuthority);

    void revoke(RoleAuthority roleAuthority);

}
