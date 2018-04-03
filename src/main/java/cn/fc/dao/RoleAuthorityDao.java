package cn.fc.dao;

import cn.fc.bean.RoleAuthority;

import java.util.List;

public interface RoleAuthorityDao {
    void insert(RoleAuthority roleAuthority);

    void delete(long id);

    void deleteAuthority(long id);

    List select(int roleId);
}
