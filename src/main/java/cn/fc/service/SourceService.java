package cn.fc.service;

import cn.fc.bean.Source;

import java.util.List;

public interface SourceService {

    Source get(long id);

    List<Source> getAllSource(int pageNum);

    boolean update(Source source);

    boolean delete(long id);
}
