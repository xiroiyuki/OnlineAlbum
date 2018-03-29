package cn.fc.serviceImpl;

import cn.fc.bean.User;
import cn.fc.dao.UserDao;
import cn.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return dao.login(user);
    }
}
