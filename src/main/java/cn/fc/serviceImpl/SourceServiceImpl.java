package cn.fc.serviceImpl;

import cn.fc.bean.Source;
import cn.fc.dao.SourceDao;
import cn.fc.service.BaseService;
import cn.fc.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean update(Source source) {
        Source old = dao.selectById(source.getId());
        dao.update(source);
        Source newSource = dao.selectById(source.getId());
        return !old.equals(newSource);
    }

    @Override
    public boolean delete(long id) {
        dao.delete(id);
        return dao.selectById(id) == null;
    }
}
