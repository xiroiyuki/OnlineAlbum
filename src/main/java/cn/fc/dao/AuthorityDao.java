package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.User;

import java.util.List;

public interface AuthorityDao {
    void insert(Authority authority);

    void delete(long id);

    List<Authority> select();

    List<Authority> selectList(Long[] ids);

    Authority selectById(long id);

    List<Authority> loadUserAuthority(User user);

    void update(Authority authority);

}
