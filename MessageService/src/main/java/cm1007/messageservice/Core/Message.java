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
    private Long sourceUserId;

    @Setter @Getter
    private Long targetUserId;

    @Setter @Getter
    private String message;

    @Setter @Getter
    private LocalDateTime sentDate;

    @Getter @Setter
    private LocalDateTime answerDate;

    @Getter @Setter
    private String answer;

    @Setter @Getter
    private User sourceUser;

    @Setter @Getter
    private User targetUser;

    public Message() {
    }

    public Message(Long sourceUserId, Long targetUserId, String message) {
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
    }

    //Lazy load
    public Message(Long id, Long sourceUserId, Long targetUserId, String message, LocalDateTime sentDate, LocalDateTime answerDate, String answer) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
        this.answerDate = answerDate;
        this.answer = answer;
    }

    //Potential eager load
    public Message(Long id, Long sourceUserId, Long targetUserId, String message, LocalDateTime sentDate,
                   LocalDateTime answerDate, String answer, User sourceUser, User targetUser) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
        this.answerDate = answerDate;
        this.answer = answer;
        this.sourceUser = sourceUser;
        this.targetUser = targetUser;
    }
}
