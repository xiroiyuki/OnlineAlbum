package cn.fc.dao;

import cn.fc.bean.Message;

import java.util.List;

public interface MsgDao {
    List<Message> select();

    Message selectById(long id);

    void insert(Message message);

    void update(Message message);

    void delete(long id);

}
