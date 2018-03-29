package cn.fc.dao;

import cn.fc.bean.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {

    Album selectById(long id);

    List<Album> selectAll();

    List<Album> selectAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<Album> selectBySource(@Param("sourceId") long sourceId);

    List<Album> selectBySource(@Param("sourceId") long sourceId, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void delete(long id);

    void update(Album album);

}
