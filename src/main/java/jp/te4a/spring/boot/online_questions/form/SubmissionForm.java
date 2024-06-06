package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmissionForm {
    @NotNull
    private String problemId;

    @NotNull
    @Min(0)
    @Max(1_000_000_000)
    @Digits(integer=10, fraction=0)
    private Integer answer;
}
