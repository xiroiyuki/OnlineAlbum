package cn.fc.dao;

import cn.fc.bean.Log;

public interface LogDao {
    void insert(Log log);

    void delete(long id);

    void clear();

}
