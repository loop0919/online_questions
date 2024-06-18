package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProblemForm {
    @NotNull
    @NotBlank
    @Size(min=1, max=30)
    String problemId;

    @NotNull
    @NotBlank
    String title;

    @NotNull
    @NotBlank
    @Min(0)
    @Max(10)
    @Digits(integer=2, fraction=0)
    Integer level;

    @NotNull
    @NotBlank
    @Min(0)
    @Max(1000)
    @Digits(integer=4, fraction=0)
    Integer point;

    String problemStatement;

    @NotNull
    @NotBlank
    @Min(0)
    @Max(1_000_000_000)
    @Digits(integer=10, fraction=0)
    Integer answer;

}
