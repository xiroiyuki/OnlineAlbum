package cn.fc.dao;

import cn.fc.bean.Role;

import java.util.List;

public interface RoleDao {
    void insert(Role role);

    List<Role> select();

    void delete(long id);

    void update(Role r);

    Role selectById(long id);

}
