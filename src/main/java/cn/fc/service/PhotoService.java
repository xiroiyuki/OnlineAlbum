package cn.fc.service;

import cn.fc.bean.Photo;

import java.util.List;
import java.util.Map;

public interface PhotoService {
    Photo get(long id);

    List<Photo> getAllByAlbum(long albumId, int pageNum);

    List<Photo> getAllByAlbum(long albumId);

    List<Photo> getAll(int pageNum);

    List<Photo> getAll();

    Map delete(long id);

    Map update(Photo photo);

}
