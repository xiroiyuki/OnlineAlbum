package cn.fc.service;

import cn.fc.bean.Album;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    Album get(long id);

    List<Album> getAllBySource(long sourceId, int pageNum);

    List<Album> getAllBySource(long sourceId);

    List<Album> getAll(int pageNum);

    List<Album> getAll();

    Map delete(long id);

    Map update(Album album);

    Map refresh(Long albumId);

}
