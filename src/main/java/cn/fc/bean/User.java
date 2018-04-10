package cn.fc.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @Size(min = 6, max = 18,message = "{Size.user.username}")
    private String username;
    @Size(min = 6, max = 18,message = "{Size.user.password}")
    private String password;
    @Min(value = 0,message = "{Min.user.state}")
    @Max(value = 1,message = "{Max.user.state}")
    private int state;
    private Role role;//ROLE_ID
    private String remark;
    private long regTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", role=" + role +
                ", remark='" + remark + '\'' +
                ", regTime=" + regTime +
                '}';
    }

    public long getRegTime() {
        return regTime;
    }

    public void setRegTime(long regTime) {
        this.regTime = regTime;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
