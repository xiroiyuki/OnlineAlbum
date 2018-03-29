package cn.fc.dao;

import cn.fc.bean.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotoDao {

    List<Photo> selectAll();

    List<Photo> selectAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<Photo> selectByAlbumId(@Param("albumId") long albumId);

    List<Photo> selectByAlbumId(@Param("albumId") long albumId, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    void delete(long id);

    void update(Photo photo);
}
