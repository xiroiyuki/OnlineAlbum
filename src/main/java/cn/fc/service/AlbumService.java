package cn.fc.service;

import cn.fc.bean.Album;

import java.util.List;

public interface AlbumService {
    Album get(long id);

    List<Album> getAllBySource(long sourceId, int pageNum);

    List<Album> getAll(int pageNum);

    boolean delete(long id);

    void update(Album album);

}
