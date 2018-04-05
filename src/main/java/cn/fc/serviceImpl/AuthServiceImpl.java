package cn.fc.serviceImpl;

import cn.fc.bean.Authority;
import cn.fc.bean.Role;
import cn.fc.bean.RoleAuthority;
import cn.fc.bean.User;
import cn.fc.dao.AuthorityDao;
import cn.fc.dao.RoleAuthorityDao;
import cn.fc.dao.RoleDao;
import cn.fc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl extends BaseService implements AuthService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> listRole() {
        return roleDao.select();
    }

    @Override
    public List<Authority> listAuthority() {
        return authorityDao.select();
    }

    @Override
    public List<Authority> listRoleAuthority(Role role) {
        List<Long> hasId = role.getAuthorities().stream().map(Authority::getId).collect(Collectors.toList());
        return authorityDao.select().stream().filter(authority -> hasId.contains(authority.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Authority> listAuthorityRole(Authority authority) {
        return null;
    }

    @Override
    public List<Authority> listRoleNotHasAuthority(Role role) {
        List<Long> hasId = role.getAuthorities().stream().map(Authority::getId).collect(Collectors.toList());
        return authorityDao.select().stream().filter(authority -> !hasId.contains(authority.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Authority> listAuthorityNotHasRole(Authority authority) {
        return null;
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
    public void revokeRole(Role role) {
        roleAuthorityDao.revokeRole(role);
    }

    @Override
    public void revokeAuthority(Authority authority) {
        roleAuthorityDao.revokeAuthority(authority);
    }


    @Override
    public void grantAuthorities(Role role, Long[] authorityIds) {
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
    public void grantRoles(Long[] roleIds, Authority authority) {

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
