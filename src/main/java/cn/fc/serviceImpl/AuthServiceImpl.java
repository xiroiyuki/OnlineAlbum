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

@Service
public class AuthServiceImpl extends BaseService implements AuthService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private RoleDao roleDao;


    public List<Role> listRole() {
        return roleDao.select();
    }

    public List<Authority> listAuthority() {
        return authorityDao.select();
    }

    public Role getRole(long id) {
        return roleDao.selectById(id);
    }

    public Authority getAuthority(long id) {
        return authorityDao.selectById(id);
    }

    public Map revoke(Role role, Authority authority) {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRole(role);
        roleAuthority.setAuthority(authority);
        roleAuthorityDao.revoke(roleAuthority);
        return null;
    }

    public Map grant(Role role, Authority authority) {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRole(role);
        roleAuthority.setAuthority(authority);
        roleAuthorityDao.grant(roleAuthority);
        return null;
    }

    public List<Authority> loadLoginUserAuthority(User user) {
        List<Authority> authority = authorityDao.loadUserAuthority(user);
        return authority;
    }

    public Map updateAuthority(Authority authority) {
        Authority temp = authorityDao.selectById(authority.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            authorityDao.update(authority);
            return createOKResultMap();
        }
    }

    public Map updateRole(Role role) {
        Role temp = roleDao.selectById(role.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            roleDao.update(role);
            return createOKResultMap();
        }
    }

    public Map deleteRole(long id) {
        Role temp = roleDao.selectById(id);
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            roleDao.delete(id);
            return createOKResultMap();
        }
    }

    public Map deleteAuthority(long id) {
        Authority temp = authorityDao.selectById(id);
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            return createOKResultMap();
        }
    }
}
