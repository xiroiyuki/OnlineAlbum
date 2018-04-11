package cn.fc.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class User {
    private int id;
    @Length(min = 6, max = 18, message = "{Length.user.username}")
    private String username;
    @Length(min = 6, max = 18, message = "{Length.user.password}")
    private String password;
    @Range(max = 1, message = "{Range.user.state}")
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
