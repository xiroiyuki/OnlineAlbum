package cn.fc.service;

import cn.fc.bean.Message;

import java.util.List;
import java.util.Map;

public interface MsgService {

    List<Message> listMessages();

    Message getMessage(Long id);

    Map delete(Long id);

    Map insert(Message message);

    Map update(Message message);

}
