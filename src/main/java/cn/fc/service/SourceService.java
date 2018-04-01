package cn.fc.service;

import cn.fc.bean.Source;

import java.util.List;
import java.util.Map;

public interface SourceService {

    Source get(long id);

    List<Source> getAllSource(int pageNum);

    Map update(Source source);

    Map delete(long id);
}
