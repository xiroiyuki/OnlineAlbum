package cn.fc.dao;

import cn.fc.bean.Authority;
import cn.fc.bean.User;

import java.util.List;

public interface AuthorityDao {
    void insert(Authority authority);

    void delete(int id);

    List select();

    Authority selectById(long id);

    List loadUserAuthority(User user);

    void update(Authority authority);

}
