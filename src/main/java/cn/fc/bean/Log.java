package cn.fc.bean;

public class Log {
    private long id;
    private Authority authority;
    private String method;
    private long reqTime;
    private User user;
    private String reqResult;

    public String getReqResult() {
        return reqResult;
    }

    public void setReqResult(String reqResult) {
        System.out.println(reqResult);
        this.reqResult = reqResult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getReqTime() {
        return reqTime;
    }

    public void setReqTime(long reqTime) {
        this.reqTime = reqTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
