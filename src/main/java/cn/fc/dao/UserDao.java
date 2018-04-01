package cn.fc.dao;

import cn.fc.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {

    List<User> selectAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<User> selectAll();

    User selectById(long id);

    User login(User user);

    void update(User user);

    void delete(long id);

    //    TODO 未完成
    void insert(User user);

}
