package cn.fc.util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ResultDataBuilder {


    private Map<String, Object> resultData;

    public ResultDataBuilder() {
        this.resultData = new HashMap<>();
    }

    public ResultDataBuilder setCode(int resultCode) {
        resultData.put("code", resultCode);
        return this;
    }

    public ResultDataBuilder setMsg(String msg) {
        resultData.put("msg", msg);
        return this;
    }

    public ResultDataBuilder setResult(Object result) {
        resultData.put("result", result);
        return this;
    }

    public Map<String, Object> create() {
        return this.resultData;
    }
}