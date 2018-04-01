package cn.fc.util;


public class ResultCode {

    private ResultCode() {
    }

    /**
     * 资源创建成功
     */
    public final static int CREATED = 201;

    /**
     * 没权限访问资源，比如非管理员删除项目组等操作
     */
    public final static int FORBIDDEN = 403;


    /**
     * 资源删除成功
     */
    public final static int NO_CONTENT = 204;

    /**
     * 创建成功，但有其他问题
     */
    public final static int CREATE_PARTLY_SUCCESS = 210;


    /**
     * 资源未变化
     */
    public final static int NOT_MODIFIED = 304;

    /**
     * 无效请求，比如请求参数不合法、请求体无法解析等等
     */
    public final static int BAD_REQUEST = 400;

    /**
     * 未授权，比如未登录情况下访问需要登录的接口，前端转向到登录页面，登录完成后继续进入此页面
     */
    public final static int UNAUTHORIZED = 401;

    /**
     * 请求成功
     */
    public final static int OK = 200;

    /**
     * 资源未找到，比如访问不存在的资源
     */
    public final static int NOT_FOUND = 404;

    /**
     * 请求方法不允许，比如用GET方法创建/修改/删除资源等操作
     */
    public final static int METHOD_NOT_ALLOWED = 405;


    /**
     * 资源已失效，比如针对已不再支持的老版本的API
     */
    public final static int GONE = 410;

    /**
     * Media Type 不支持
     */
    public final static int UNSUPPORTED_MEDIA_TYPE = 415;


    /**
     * 不能处理的资源，比如调用了删除默认项目组等不允许操作的接口
     */
    public final static int UNPROCESSABLE_ENTITY = 422;

    /**
     * 不能处理的资源，比如调用了删除默认项目组等不允许操作的接口
     */
    public final static int INTERNAL_SERVER_ERROR = 500;

}
