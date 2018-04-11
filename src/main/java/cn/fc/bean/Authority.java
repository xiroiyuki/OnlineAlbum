package cn.fc.bean;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class Authority {
    private long id;
    @NotBlank(message = "{NotBlank.authority.name}")
    private String name;
    @NotBlank(message = "{NotBlank.authority.url}")
    private String url;

    private List<Role> roles;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", hasRoles=" + (roles == null) +
                '}';
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
