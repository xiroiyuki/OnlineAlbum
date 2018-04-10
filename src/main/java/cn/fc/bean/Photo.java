package cn.fc.bean;

import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.Size;

public class Photo {
    private long id;
    @Size(min = 1,message = "{Size.photo.url}")
    private String url;
    @SerializedName("album_id")
    private long albumId;//ALBUM_ID

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", albumId=" + albumId +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
}
