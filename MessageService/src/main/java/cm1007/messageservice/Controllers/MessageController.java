package cm1007.messageservice.Controllers;

import cm1007.messageservice.Core.Interfaces.IMessageService;
import cm1007.messageservice.Core.Message;
import cm1007.messageservice.ViewModels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService _messageService;

    @GetMapping("/source/{userId}")
    public ResponseEntity<List<MessageVM>> getMessagesBySourceId(@PathVariable String userId){
        List<Message> messages = _messageService.getMessagesBySourceId(userId);
        if (messages == null)
            return ResponseEntity.badRequest().build();

        List<MessageVM> messageVMs = mapToMessageVM(messages);
        return ResponseEntity.ok(messageVMs);
    }

    @GetMapping("/target/{userId}")
    public ResponseEntity<List<MessageVM>> getMessagesByTargetId(@PathVariable String userId){
        List<Message> messages = _messageService.getMessagesByTargetId(userId);
        if (messages == null)
            return ResponseEntity.badRequest().build();

        List<MessageVM> messageVMs = mapToMessageVM(messages);
        return ResponseEntity.ok(messageVMs);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody MessageCreateVM m){
        boolean isMessageSent = _messageService.sendMessage(m.getSourceUserId(), m.getTargetUserId(), m.getMessage());
        if(!isMessageSent)
            return ResponseEntity.badRequest().body("Message failed to send");
        return ResponseEntity.ok().body("Message sent successfully!");
    }

    @PostMapping("/answer/{messageId}")
    public ResponseEntity<String> answerMessage(@PathVariable Long messageId, @RequestBody MessageAnswerVM answer){
        boolean isMessageAnswered = _messageService.answerMessage(messageId, answer.getAnswer());
        if(!isMessageAnswered)
            return ResponseEntity.badRequest().body("Message already answered or failed");
        return ResponseEntity.ok().body("Message answered successfully!");
    }

    private List<MessageVM> mapToMessageVM(List<Message> messages){
        List<MessageVM> result = new ArrayList<>();
        for (Message m : messages) {
            result.add(new MessageVM(m.getId(), m.getSourceUserId(), m.getTargetUserId(),
                    m.getMessage(), m.getSentDate(), m.getAnswerDate(), m.getAnswer()));
        }
        return result;
    }
}
