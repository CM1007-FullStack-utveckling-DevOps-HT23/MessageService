package cm1007.messageservice.Core;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Message {
    @Setter @Getter
    private Long id;

    @Setter @Getter
    private String sourceUserId;

    @Setter @Getter
    private String targetUserId;

    @Setter @Getter
    private String message;

    @Setter @Getter
    private LocalDateTime sentDate;

    @Getter @Setter
    private LocalDateTime answerDate;

    @Getter @Setter
    private String answer;

    public Message() {
    }

    public Message(String sourceUserId, String targetUserId, String message) {
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
    }

    //Lazy load
    public Message(Long id, String sourceUserId, String targetUserId, String message, LocalDateTime sentDate, LocalDateTime answerDate, String answer) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
        this.answerDate = answerDate;
        this.answer = answer;
    }
}
