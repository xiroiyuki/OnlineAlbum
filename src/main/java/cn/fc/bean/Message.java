package cn.fc.bean;

import javax.validation.constraints.Size;

public class Message {
    private long id;
    @Size(min = 1,message = "{Size.message.title}")
    private String title;
    @Size(min = 1,message = "{Size.message.content}")
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
