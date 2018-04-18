package cn.fc.dao;

import cn.fc.bean.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LogDao {
    void insert(Log log);

    void delete(long id);

    void clear();

    List<Log> select();

    List<Map> selectCountsGroupByHour(@Param("start") long start, @Param("end") long end);

    List<Map> selectCountsGroupByMonthDay(@Param("start") long start, @Param("end") long end);

    List<Map> selectCountsGroupByWeekday(@Param("start") long start, @Param("end") long end);

}
