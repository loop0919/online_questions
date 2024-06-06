package jp.te4a.spring.boot.online_questions.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="problems")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemBean {
    @Id
    @Column(name="problem_id")
    private String problemId;

    @Column(name="title")
    private String title;

    @Column(name="level")
    private Integer level;

    @Column(name="point")
    private Integer point;

    @Column(name="problem_statement")
    private String problemStatement;

    @Column(name="answer")
    private Integer answer;
}
