package jp.te4a.spring.boot.online_questions.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProblemForm {
    @NotNull
    @Size(min=1, max=30)
    String problemId;

    @NotNull
    String title;

    @NotNull
    @Min(0)
    @Max(10)
    @Digits(integer=2, fraction=0)
    Integer level;

    @NotNull
    @Min(0)
    @Max(1000)
    @Digits(integer=4, fraction=0)
    Integer point;

    @NotNull
    String problemStatement;

    @NotNull
    @Min(0)
    @Max(1_000_000_000)
    @Digits(integer=10, fraction=0)
    Integer answer;

}
