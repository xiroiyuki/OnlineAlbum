package cn.fc.service;

import cn.fc.bean.Source;

import java.util.List;

public interface SourceService {

    List<Source> getAllSource(int pageNum);

    boolean update(Source source);

    boolean delete(long id);
}
