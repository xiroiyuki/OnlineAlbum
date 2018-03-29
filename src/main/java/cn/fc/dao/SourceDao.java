package cn.fc.dao;

import cn.fc.bean.Source;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourceDao {
    List<Source> select();

    List<Source> select(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void update(Source source);

    void delete(long id);

}
