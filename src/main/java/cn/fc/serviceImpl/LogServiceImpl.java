package cn.fc.serviceImpl;

import cn.fc.bean.Log;
import cn.fc.dao.LogDao;
import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao dao;

    @Override
    public void saveLog(Log log) {
        dao.insert(log);
    }
}
