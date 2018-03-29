package cn.fc.dao;

import cn.fc.bean.User;


public interface UserDao {

    User selectById(long id);

    User login(User user);

    void update(User user);

}
