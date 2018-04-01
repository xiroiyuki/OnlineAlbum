package cn.fc.serviceImpl;

import cn.fc.bean.Source;
import cn.fc.dao.SourceDao;
import cn.fc.service.BaseService;
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
        dao.update(source);
        return super.resultDataBuilder.setCode(200).setMsg("修改成功").setResult(true).create();
    }

    @Override
    public Map delete(long id) {
        dao.delete(id);
        return super.resultDataBuilder.setCode(200).setMsg("删除成功").setResult(true).create();
    }
}
