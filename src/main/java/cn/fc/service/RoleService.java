package cn.fc.service;

import cn.fc.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> listRoles();

    Role getRole(long id);

    Map updateRole(Role role);

    Map deleteRole(long id);

    Map insertRole(Role role);

}
