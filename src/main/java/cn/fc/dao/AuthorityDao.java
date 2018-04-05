package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.User;

import java.util.List;

public interface AuthorityDao {
    void insert(Authority authority);

    void delete(long id);

    List<Authority> select();

    Authority selectById(long id);

    List<Authority> selectByIds(Long[] ids);

    void update(Authority authority);

    List<Authority> loadUserAuthority(User user);

}
