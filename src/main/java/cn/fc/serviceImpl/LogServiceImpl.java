package cn.fc.serviceImpl;

import cn.fc.bean.Log;
import cn.fc.dao.LogDao;
import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LogServiceImpl extends BaseService implements LogService {

    @Autowired
    private LogDao dao;

    @Override
    public void saveLog(Log log) {
        dao.insert(log);
    }

    @Override
    public List<Log> listLogs() {
        return dao.select();
    }

    @Override
    public Map clear() {
        dao.clear();
        return createOKResultMap();
    }

    @Override
    public List listCountsGroupByHour() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long start = calendar.getTimeInMillis() / 1000;
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        long end = calendar.getTimeInMillis() / 1000;
        long[] data = new long[calendar.getActualMaximum(Calendar.HOUR_OF_DAY)];
        List<Map> dayOfMonthData = dao.selectCountsGroupByHour(start, end);
        for (Map datum : dayOfMonthData) {
            data[(int) datum.get("hour")] = (long) datum.get("count");
        }
        System.out.println(Arrays.toString(data));
        return Arrays.asList(data);
    }

    @Override
    public List listCountsGroupByMonthDay() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long start = calendar.getTimeInMillis() / 1000;
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        long end = calendar.getTimeInMillis() / 1000;
        long[] data = new long[calendar.getActualMaximum(Calendar.DAY_OF_MONTH)];
        List<Map> dayOfMonthData = dao.selectCountsGroupByMonthDay(start, end);
        for (Map datum : dayOfMonthData) {
            data[(int) datum.get("dayOfMonth") - 1] = (long) datum.get("count");
        }
        System.out.println(Arrays.toString(data));
        return Arrays.asList(data);
    }

    @Override
    public List listCountsGroupByWeekday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long start = calendar.getTimeInMillis() / 1000;
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        long end = calendar.getTimeInMillis() / 1000;
        List<Map> weekdayData = dao.selectCountsGroupByWeekday(start, end);
        long[] data = new long[7];
        for (Map datum : weekdayData) {
            data[(int) datum.get("weekday")] = (long) datum.get("count");
        }
        System.out.println(Arrays.toString(data));
        return Arrays.asList(data);
    }

}
