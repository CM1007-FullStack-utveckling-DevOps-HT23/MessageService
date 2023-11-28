package cm1007.messageservice.ViewModels;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class MessageAnswerVM {
    @NotNull
    @NotEmpty
    @Setter @Getter
    String answer;
}
