package cn.fc.serviceImpl;

import cn.fc.conf.AppConfiguration;
import cn.fc.util.ResultCode;
import cn.fc.util.ResultDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaseService {
    @Autowired
    protected AppConfiguration configuration;
    @Autowired
    protected ResultDataBuilder resultDataBuilder;

    public Map createResultMap(int code, String msg, Object result) {
        return resultDataBuilder.
                setCode(code).
                setMsg(msg).
                setResult(result).
                create();

    }

    protected Map createOKResultMap() {
        return createResultMap(ResultCode.OK, "操作成功", true);
    }

    protected Map createOKResultMap(Object data) {
        return createResultMap(ResultCode.OK, "操作成功", data);
    }

    protected Map createExceptionResultMap() {
        return createResultMap(ResultCode.INTERNAL_SERVER_ERROR, "服务器内部错误", false);
    }

    protected Map createNotFoundResultMap() {
        return createResultMap(ResultCode.NOT_FOUND, "没有找到目标资源", false);
    }

    protected Map createUnauthorizedResultMap() {
        return createResultMap(ResultCode.UNAUTHORIZED, "访问未被授权", false);
    }
}
