package cn.fc.bean;

import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Album {

    private long id;
    @NotNull()
    @Size(min = 1, message = "{Size.album.title}")
    private String title;
    private String intro;
    @SerializedName("face_url")
    private String faceUrl;
    @SerializedName("photo_num")
    private int photoNum;
    @NotNull
    @Size(min = 1)
    private String url;
    @SerializedName("create_time")
    private long createTime;
    @SerializedName("source_id")
    private long sourceId;//SOURCE_ID

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", photoNum=" + photoNum +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", sourceId=" + sourceId +
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public int getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(int photoNum) {
        this.photoNum = photoNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

}
