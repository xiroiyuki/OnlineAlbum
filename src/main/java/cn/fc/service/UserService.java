package cn.fc.service;

import cn.fc.bean.User;

public interface UserService {

    User login(String username, String password);

    boolean updatePassword(long id,String oldPass, String newPass);
}
