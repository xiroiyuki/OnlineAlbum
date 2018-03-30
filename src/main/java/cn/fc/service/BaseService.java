package cn.fc.service;

import cn.fc.conf.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
    @Autowired
    protected AppConfiguration configuration;


}
