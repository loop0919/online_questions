package jp.te4a.spring.boot.online_questions.bean;

import java.time.LocalDateTime;
import java.util.Objects;

import de.huxhorn.sulky.ulid.ULID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jp.te4a.spring.boot.online_questions.enumerations.JudgeResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="submission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBean {
    @Id
    @Column(name="submission_id")
    String submissionId;

    @Column(name="submission_datetime")
    @NotNull
    LocalDateTime submissionDatetime;

    @Column(name="user_id")
    String userId;

    @Column(name="problem_id")
    String problemId;

    @Column(name="answer")
    Integer answer;

    @Column(name="judge_result")
    @Enumerated(EnumType.STRING)
    JudgeResult judgeResult;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.submissionId)) {
            this.submissionId = new ULID().nextULID();
        }
    }
}
