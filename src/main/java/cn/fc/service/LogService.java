package cn.fc.service;

import cn.fc.bean.Log;

import java.util.List;
import java.util.Map;

public interface LogService {

    void saveLog(Log log);

    List<Log> listLogs();

    Map clear();

    List<Long> listCountsGroupByHour();

    List<Long> listCountsGroupByMonthDay();

    List<Long> listCountsGroupByWeekday();
}
