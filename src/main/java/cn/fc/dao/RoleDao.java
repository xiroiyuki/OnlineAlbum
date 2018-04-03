package cn.fc.dao;

import cn.fc.bean.Role;

import java.util.List;

public interface RoleDao {
    void insert(Role role);

    void delete(long id);

    List select();

    Role edit(long id);

    void update(Role r);
}
