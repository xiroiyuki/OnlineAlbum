package cn.fc.serviceImpl;

import cn.fc.bean.Source;
import cn.fc.dao.SourceDao;
import cn.fc.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SourceServiceImpl extends BaseService implements SourceService {

    @Autowired
    private SourceDao dao;

    @Override
    public Source get(long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Source> getAllSource(int pageNum) {
        return dao.select(pageNum, super.configuration.getPageSize());
    }

    @Override
    public Map update(Source source) {
        Source temp = dao.selectById(source.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            dao.update(source);
            return createOKResultMap();
        }
    }

    @Override
    public Map delete(long id) {
        Source source = dao.selectById(id);
        if (source == null) {
            return createNotFoundResultMap();
        } else {
            dao.delete(id);
            return createOKResultMap();
        }
    }
}
