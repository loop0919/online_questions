package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserForm {
    @NotNull
    @Size(min=1, max=16)
    private String username;

    @NotNull
    @Size(min=6, max=128)
    private String password;
}
