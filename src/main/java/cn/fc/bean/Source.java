package cn.fc.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Source {
    private long id;
    @NotNull
    @Size(min = 1)
    private String url;
    @NotNull
    @Size(min = 1)
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
