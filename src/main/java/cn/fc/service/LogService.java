package cn.fc.service;

import cn.fc.bean.Log;

import java.util.List;
import java.util.Map;

public interface LogService {

    void saveLog(Log log);

    List<Log> listLogs();

    Map clear();

    List listCountsGroupByHour();

    List listCountsGroupByMonthDay();

    List listCountsGroupByWeekday();
}
