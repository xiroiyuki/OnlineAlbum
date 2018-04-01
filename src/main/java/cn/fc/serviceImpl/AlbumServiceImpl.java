package cn.fc.serviceImpl;

import cn.fc.bean.Album;
import cn.fc.dao.AlbumDao;
import cn.fc.service.AlbumService;
import cn.fc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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
    public List<Album> getAll(int pageNum) {
        return dao.selectAll(pageNum, super.configuration.getPageSize());
    }

    @Override
    public Map delete(long id) {
        Album album = dao.selectById(id);
        if (album == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.delete(id);
            return super.createOKResultMap();
        }
    }

    @Override
    public Map update(Album album) {
        Album temp = dao.selectById(album.getId());
        if (temp == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.update(album);
            return super.createOKResultMap();
        }
    }
}
