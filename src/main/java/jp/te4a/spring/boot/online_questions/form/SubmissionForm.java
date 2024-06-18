package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmissionForm {
    @NotNull
    @NotBlank
    @NotEmpty
    private String problemId;

    @NotNull
    @NotBlank
    @NotEmpty
    @Min(0)
    @Max(1_000_000_000)
    @Digits(integer=10, fraction=0)
    private Integer answer;
}
