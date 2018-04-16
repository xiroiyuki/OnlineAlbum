package cn.fc.dao;

import cn.fc.bean.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {
    void insert(Log log);

    void delete(long id);

    void clear();

    List<Log> select();


//    SELECT
//	count(*)
//FROM
//	`log`
//WHERE
//	req_time BETWEEN  0点 AND 23点59
//GROUP BY
//	HOUR (
//		FROM_UNIXTIME(
//			req_time,
//			'%Y-%m-%d %H:%i:%s'
//		)
//	)

    List<Long> selectCountsGroupByHour(@Param("start") long start, @Param("end") long end);


    //SELECT
//	count(*)
//FROM
//	`log`
//WHERE
//	req_time BETWEEN  元旦 AND 年底
//GROUP BY
//	MONTH (
//		FROM_UNIXTIME(
//			req_time,
//			'%Y-%m-%d %H:%i:%s'
//		)
//	)
    List<Long> selectCountsGroupByMonthDay(@Param("start") long start, @Param("end") long end);

    //    SELECT
////    count(*),
////    FROM
////	`log`
////    WHERE
////    req_time BETWEEN 周一 AND 周日
////    GROUP BY
////    WEEKDAY (
////            FROM_UNIXTIME(
////            req_time,
////			'%Y-%m-%d %H:%i:%s'
////    )
////	)
    List<Long> selectCountsGroupByWeekday(@Param("start") long start, @Param("end") long end);


}
