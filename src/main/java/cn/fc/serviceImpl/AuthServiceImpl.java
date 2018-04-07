package cn.fc.serviceImpl;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;
import cn.fc.bean.User;
import cn.fc.dao.AuthorityDao;
import cn.fc.dao.RoleAuthorityDao;
import cn.fc.dao.RoleDao;
import cn.fc.service.AuthorityService;
import cn.fc.service.RoleAuthorityService;
import cn.fc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl extends BaseService implements RoleAuthorityService, RoleService, AuthorityService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listRoles() {
        return roleDao.select();
    }

    @Override
    public List<Authority> listAuthorities() {
        return authorityDao.select();
    }

    @Override
    public List<Authority> listAuthoritiesFromRole(Role role) {
        List<Long> hasId = role.getAuthorities().stream().map(Authority::getId).collect(Collectors.toList());
        if (hasId.isEmpty()) {
            return new ArrayList<>();
        }
        return authorityDao.selectByIds(hasId.toArray(new Long[]{}));
    }

    @Override
    public List<Role> listRolesFromAuthority(Authority authority) {
        List<Long> hasId = authority.getRoles().stream().map(Role::getId).collect(Collectors.toList());
        if (hasId.isEmpty()) {
            return new ArrayList<>();
        }
        return roleDao.selectByIds(hasId.toArray(new Long[]{}));
    }

    @Override
    public List<Authority> listExceptAuthoritiesFromRole(Role role) {
        List<Long> hasId = role.getAuthorities().stream().map(Authority::getId).collect(Collectors.toList());
        if (hasId.isEmpty()) {
            return authorityDao.select();
        }
        return authorityDao.selectExceptByIds(hasId.toArray(new Long[]{}));
    }

    @Override
    public List<Role> listExceptRolesFromAuthority(Authority authority) {
        List<Long> hasId = authority.getRoles().stream().map(Role::getId).collect(Collectors.toList());
        if (hasId.isEmpty()) {
            return roleDao.select();
        }
        return roleDao.selectExceptByIds(hasId.toArray(new Long[]{}));
    }

    @Override
    public Role getRole(long id) {
        return roleDao.selectById(id);
    }

    @Override
    public Authority getAuthority(long id) {
        return authorityDao.selectById(id);
    }

    @Override
    public void revokeRoleFromAllAuthorities(Role role) {
        roleAuthorityDao.revokeRole(role);
    }

    @Override
    public void revokeAuthorityFromAllRoles(Authority authority) {
        roleAuthorityDao.revokeAuthority(authority);
    }


    @Override
    public void grantAuthoritiesToRole(Long[] authorityIds, Role role) {
        List<Authority> authorities = authorityDao.selectByIds(authorityIds);
        List<RoleAuthority> roleAuthorities = authorities.stream().map(authority -> {
            RoleAuthority roleAuthority = new RoleAuthority();
            roleAuthority.setAuthority(authority);
            roleAuthority.setRole(role);
            return roleAuthority;
        }).collect(Collectors.toList());
        roleAuthorityDao.grantRoleAuthorities(roleAuthorities);
    }

    @Override
    public void grantRolesToAuthority(Long[] roleIds, Authority authority) {
        List<Role> roles = roleDao.selectByIds(roleIds);
        List<RoleAuthority> authorityRoles = roles.stream().map(role -> {
            RoleAuthority roleAuthority = new RoleAuthority();
            roleAuthority.setRole(role);
            roleAuthority.setAuthority(authority);
            return roleAuthority;
        }).collect(Collectors.toList());
        roleAuthorityDao.grantRoleAuthorities(authorityRoles);
    }

    @Override
    public List<Authority> loadLoginUserAuthority(User user) {
        return authorityDao.loadUserAuthority(user);
    }

    @Override
    public Map updateAuthority(Authority authority) {
        Authority temp = authorityDao.selectById(authority.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            authorityDao.update(authority);
            return createOKResultMap();
        }
    }

    @Override
    public Map updateRole(Role role) {
        Role temp = roleDao.selectById(role.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            roleDao.update(role);
            return createOKResultMap();
        }
    }

    @Override
    public Map deleteRole(long id) {
        Role temp = roleDao.selectById(id);
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            roleDao.delete(id);
            return createOKResultMap();
        }
    }

    @Override
    public Map deleteAuthority(long id) {
        Authority temp = authorityDao.selectById(id);
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            authorityDao.delete(id);
            return createOKResultMap();
        }
    }

    @Override
    public Map insertAuthority(Authority authority) {
        authorityDao.insert(authority);
        return createOKResultMap();
    }

    @Override
    public Map insertRole(Role role) {
        roleDao.insert(role);
        return createOKResultMap();
    }
}
