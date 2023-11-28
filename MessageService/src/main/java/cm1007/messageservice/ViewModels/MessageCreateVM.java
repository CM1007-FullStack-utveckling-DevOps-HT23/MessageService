package cm1007.messageservice.ViewModels;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessageCreateVM {
    @NotNull
    @Setter @Getter
    Long sourceUserId;
    @NotNull
    @Setter @Getter
    Long targetUserId;
    @NotNull
    @NotEmpty
    @Setter @Getter
    String message;

    public MessageCreateVM() {
    }

    public MessageCreateVM(Long sourceUserId, Long targetUserId, String message) {
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.message = message;
    }
}
