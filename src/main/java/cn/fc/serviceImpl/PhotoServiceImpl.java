package cn.fc.serviceImpl;

import cn.fc.bean.Photo;
import cn.fc.dao.PhotoDao;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhotoServiceImpl extends BaseService implements PhotoService {

    @Autowired
    private PhotoDao dao;

    @Override
    public Photo get(long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Photo> getAllByAlbum(long albumId, int pageNum) {
        return dao.selectByAlbumId(albumId, pageNum, super.configuration.getPageSize());
    }

    @Override
    public List<Photo> getAllByAlbum(long albumId) {
        return dao.selectByAlbumId(albumId);
    }

    @Override
    public List<Photo> getAll(int pageNum) {
        return dao.selectAll(pageNum, super.configuration.getPageSize());
    }

    @Override
    public Map delete(long id) {
        Photo photo = dao.selectById(id);
        if (photo == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.delete(id);
            return super.createOKResultMap();
        }
    }

    @Override
    public Map update(Photo photo) {
        Photo temp = dao.selectById(photo.getId());
        if (temp == null) {
            return super.createNotFoundResultMap();
        } else {
            dao.update(photo);
            return super.createOKResultMap();
        }
    }
}
