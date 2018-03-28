package serviceImpl;

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
    public User login(User user) {

        return dao.login(user);
    }
}
