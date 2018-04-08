package cn.fc.serviceImpl;

import cn.fc.bean.Message;
import cn.fc.dao.MsgDao;
import cn.fc.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl extends BaseService implements MsgService {


    @Autowired
    private MsgDao dao;

    @Override
    public List<Message> listMessages() {
        return dao.select();
    }

    @Override
    public Message getMessage(Long id) {
        return dao.selectById(id);
    }

    @Override
    public Map delete(Long id) {
        Message temp = this.getMessage(id);
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            dao.delete(id);
            return createOKResultMap();
        }
    }

    @Override
    public Map insert(Message message) {
        dao.insert(message);
        return createOKResultMap();
    }

    @Override
    public Map update(Message message) {
        Message temp = this.getMessage(message.getId());
        if (temp == null) {
            return createNotFoundResultMap();
        } else {
            dao.update(message);
            return createOKResultMap();
        }
    }

}
