package cn.fc.bean;

import org.hibernate.validator.constraints.NotBlank;

public class Source {
    private long id;
    @NotBlank(message = "{NotBlank.source.url}")
    private String url;
    @NotBlank(message = "{NotBlank.source.name}")
    private String name;

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
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
