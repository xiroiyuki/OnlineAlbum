package cn.fc.dao;

import cn.fc.bean.Log;

import java.util.List;

public interface LogDao {
    void insert(Log log);

    void delete(long id);

    void clear();

    List<Log> select();

}
