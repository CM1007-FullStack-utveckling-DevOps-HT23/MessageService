package cm1007.messageservice.Persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Message_T")
public class Message_T {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Column(name = "source_user_id")
    @Getter @Setter
    private String sourceUserId; // User source id

    @Column(name = "target_user_id")
    @Getter @Setter
    private String targetUserId; // User dest. id

    @Getter @Setter
    private String message;

    //Will be represented as "TIMESTAMP" with both DATE and TIME.
    @Column(name = "sent_date")
    @Getter @Setter
    private LocalDateTime sentDate;

    @Column(name = "answer_date")
    @Getter @Setter
    private LocalDateTime answerDate;

    @Getter @Setter
    private String answer;

    public Message_T(){
    }

    public Message_T(String sourceUserId, String targetUserId, String message, LocalDateTime sentDate){
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
    }

    public Message_T(String sourceUserId, String targetUserId, String message, LocalDateTime sentDate, LocalDateTime answerDate, String answer) {
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
        this.sentDate = sentDate;
        this.answerDate = answerDate;
        this.answer = answer;
    }
}
