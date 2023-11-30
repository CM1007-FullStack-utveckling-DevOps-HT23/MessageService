package cm1007.messageservice.Persistence;

import cm1007.messageservice.Core.Interfaces.IMessagePersistence;
import cm1007.messageservice.Core.Message;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessagePersistence implements IMessagePersistence {
    @Autowired
    private MessageRepository _messageRepository;


    @Override
    public List<Message> getMessagesBySourceId(Long userId) {
        if(userId == null) return null;
        List<Message_T> messages = _messageRepository.findAllBySourceUserId(userId); //This will never return null

        List<Message> result = new ArrayList<>();
        for(Message_T m : messages){
            result.add(new Message(m.getId(),m.getSourceUserId(), m.getTargetUserId(), m.getMessage(),
                    m.getSentDate(), m.getAnswerDate(), m.getAnswer()));
        }
        return result;
    }

    //Take out messages that are answered
    @Override
    public List<Message> getMessagesByTargetId(Long userId) {
        if(userId == null) return null;
        List<Message_T> messages = _messageRepository.findAllByTargetUserIdAndAnswerIsNull(userId); //This will never return null

        List<Message> result = new ArrayList<>();
        for(Message_T m : messages){
            result.add(new Message(m.getId(),m.getSourceUserId(), m.getTargetUserId(), m.getMessage(),
                    m.getSentDate(), m.getAnswerDate(), m.getAnswer()));
        }
        return result;
    }

    @Override
    @Transactional
    public boolean sendMessage(Long sourceUserId, Long targetUserId, String message) {
        if(sourceUserId == null || targetUserId == null || message == null)
            return false;

        _messageRepository.save(new Message_T(sourceUserId, targetUserId, message, LocalDateTime.now()));
        return true;
    }

    @Override
    @Transactional
    public boolean answerMessage(Long messageId, String answer) {
        if(messageId == null || answer == null)
            return false;
        Optional<Message_T> optionalMessage = _messageRepository.findById(messageId);

        if(optionalMessage.isPresent()) {
            Message_T message = optionalMessage.get();
            message.setAnswer(answer);
            message.setAnswerDate(LocalDateTime.now());
            _messageRepository.save(message);
            return true;
        }

        return false;
    }
}
