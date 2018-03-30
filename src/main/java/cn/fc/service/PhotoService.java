package cn.fc.service;

import cn.fc.bean.Photo;

import java.util.List;

public interface PhotoService {
    Photo get(long id);

    List<Photo> getAllByAlbum(long albumId,int pageNum);

    boolean delete(long id);

    boolean update(Photo photo);

}
