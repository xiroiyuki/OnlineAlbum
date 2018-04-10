package cn.fc.serviceImpl;

import cn.fc.context.AlbumContext;
import cn.fc.util.ResultCode;
import cn.fc.util.ResultDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class BaseService {
    @Autowired
    protected AlbumContext configuration;
    @Autowired
    protected ResultDataBuilder resultDataBuilder;

    public Map createResultMap(int code, String msg, Object result) {
        return resultDataBuilder.
                setCode(code).
                setMsg(msg).
                setResult(result).
                create();

    }

    public Map createOKResultMap() {
        return createResultMap(ResultCode.OK, "操作成功", true);
    }

    public Map createOKResultMap(Object data) {
        return createResultMap(ResultCode.OK, "操作成功", data);
    }

    public Map createExceptionResultMap() {
        return createResultMap(ResultCode.INTERNAL_SERVER_ERROR, "服务器内部错误", false);
    }

    public Map createExceptionResultMap(String msg) {
        return createResultMap(ResultCode.INTERNAL_SERVER_ERROR, msg, false);
    }

    public Map createNotFoundResultMap() {
        return createResultMap(ResultCode.NOT_FOUND, "没有找到目标资源", false);
    }

    public Map createUnauthorizedResultMap() {
        return createResultMap(ResultCode.UNAUTHORIZED, "访问未被授权", false);
    }

    public Map errorHandler(BindingResult result,HttpServletResponse response){
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuffer sb = new StringBuffer();
        fieldErrors.forEach(fieldError -> sb.append(fieldError.getDefaultMessage()).append(";"));
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println(sb.toString());
        return createResultMap(ResultCode.BAD_REQUEST, sb.toString(), false);
    }
}
