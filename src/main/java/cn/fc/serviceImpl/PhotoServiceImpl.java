package cn.fc.serviceImpl;

import cn.fc.bean.Photo;
import cn.fc.dao.PhotoDao;
import cn.fc.service.BaseService;
import cn.fc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean delete(long id) {
        dao.delete(id);
        return dao.selectById(id) == null;
    }

    @Override
    public boolean update(Photo photo) {
        Photo old = dao.selectById(photo.getId());
        dao.update(photo);
        Photo newPhoto = dao.selectById(photo.getId());
        return !old.equals(newPhoto);
    }
}
