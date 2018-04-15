package cn.fc.serviceImpl;

import cn.fc.bean.Log;
import cn.fc.dao.LogDao;
import cn.fc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
}
