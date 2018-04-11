package cn.fc.bean;

import org.hibernate.validator.constraints.NotBlank;

public class Message {
    private long id;
    @NotBlank(message = "{NotBlank.message.title}")
    private String title;
    @NotBlank(message = "{NotBlank.message.content}")
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
