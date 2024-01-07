package cm1007.messageservice.Core.Interfaces;

import cm1007.messageservice.Core.Message;

import java.util.List;

public interface IMessageService {

    List<Message> getMessagesBySourceId(String userId);

    List<Message> getMessagesByTargetId(String userId);

    boolean sendMessage(String sourceUserId, String targetUserId, String message);

    boolean answerMessage(Long messageId, String answer);
}
