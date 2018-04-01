package cn.fc.serviceImpl;

import cn.fc.bean.User;
import cn.fc.dao.UserDao;
import cn.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return dao.login(user);
    }

    @Override
    public Map update(User user) {
        User temp = dao.selectById(user.getId());
        if (temp == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.update(user);
            return super.createOKResultMap();
        }
    }

    @Override
    public Map delete(Long id) {
        User user = dao.selectById(id);
        if (user == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.delete(id);
            return super.createOKResultMap();
        }
    }

    @Override
    public List<User> listAll() {
        return dao.selectAll();
    }

    @Override
    public List<User> listAll(int pageNum) {
        return dao.selectAll(pageNum, super.configuration.getPageSize());
    }
}
