package cn.fc.serviceImpl;

import cn.fc.bean.Album;
import cn.fc.dao.AlbumDao;
import cn.fc.service.AlbumService;
import cn.fc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl extends BaseService implements AlbumService {

    @Autowired
    private AlbumDao dao;

    @Override
    public Album get(long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Album> getAllBySource(long sourceId, int pageNum) {
        return dao.selectBySource(sourceId, pageNum, super.configuration.getPageSize());
    }

    @Override
    public boolean delete(long id) {
        dao.delete(id);
        return dao.selectById(id) == null;
    }

    @Override
    public boolean update(Album album) {
        Album old = dao.selectById(album.getId());
        dao.update(album);
        Album newAlbum = dao.selectById(album.getId());
        return newAlbum.equals(old);
    }
}
