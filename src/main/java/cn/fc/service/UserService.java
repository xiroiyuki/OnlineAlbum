package cn.fc.service;

import cn.fc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User login(String username, String password);

    Map update(User user);

    Map delete(Long id);

    List<User> listAll();

    List<User> listAll(int pageNum);
}
