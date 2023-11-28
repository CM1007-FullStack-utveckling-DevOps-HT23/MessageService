package cm1007.messageservice.Core.Interfaces;

import cm1007.messageservice.Core.Message;

import java.util.List;

public interface IMessagePersistence {
    List<Message> getMessagesBySourceId(Long userId);
    List<Message> getMessagesByTargetId(Long userId);
    boolean sendMessage(Long sourceUserId, Long targetUserId, String message);
    boolean answerMessage(Long messageId, String answer);
}
