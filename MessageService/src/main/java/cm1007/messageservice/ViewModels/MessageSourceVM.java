package cm1007.messageservice.ViewModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class MessageSourceVM {
    @Setter
    @Getter
    private Long id;

    @Setter @Getter
    private Long sourceUserId;

    @Setter @Getter
    private Long targetUserId;

    @Setter @Getter
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Setter @Getter
    private LocalDateTime sentDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    private LocalDateTime answerDate;

    @Getter @Setter
    private String answer;

    @Getter @Setter
    private String targetFullName;

    @Getter @Setter
    private String sourceFullName;

    public MessageSourceVM() {}

    public MessageSourceVM(Long id, Long sourceUserId, Long targetUserId, String message,
                           LocalDateTime sentDate, LocalDateTime answerDate, String answer, String targetFullName, String sourceFullName) {
        this.id = id;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
        this.answerDate = answerDate;
        this.answer = answer;
        this.targetFullName = targetFullName;
        this.sourceFullName = sourceFullName;
    }
}
