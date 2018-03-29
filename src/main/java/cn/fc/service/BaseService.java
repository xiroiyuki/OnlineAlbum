package cn.fc.service;

import cn.fc.bean.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
    @Autowired
    private AppConfiguration configuration;
}
