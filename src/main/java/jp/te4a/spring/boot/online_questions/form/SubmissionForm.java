package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmissionForm {
    @NotBlank
    private String problemId;

    @NotNull
    @Min(1)
    @Max(1_000_000_000)
    private Integer answer;
}
