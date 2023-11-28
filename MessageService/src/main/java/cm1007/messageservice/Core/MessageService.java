package cm1007.messageservice.Core;

import cm1007.messageservice.Core.Interfaces.IMessageService;
import cm1007.messageservice.Core.Interfaces.IMessagePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessagePersistence _messagePersistence;

    @Override
    public List<Message> getMessagesBySourceId(Long userId) {
        return _messagePersistence.getMessagesBySourceId(userId);
    }

    @Override
    public List<Message> getMessagesByTargetId(Long userId) {
        return _messagePersistence.getMessagesByTargetId(userId);
    }

    @Override
    public boolean sendMessage(Long sourceUserId, Long targetUserId, String message) {
        return _messagePersistence.sendMessage(sourceUserId, targetUserId, message);
    }

    @Override
    public boolean answerMessage(Long messageId, String answer) {
        return _messagePersistence.answerMessage(messageId, answer);
    }
}
