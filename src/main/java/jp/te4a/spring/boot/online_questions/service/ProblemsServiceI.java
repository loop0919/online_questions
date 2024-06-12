package jp.te4a.spring.boot.online_questions.service;

import java.util.List;
import java.util.NoSuchElementException;

import jp.te4a.spring.boot.online_questions.form.ProblemForm;
import jp.te4a.spring.boot.online_questions.form.SubmissionForm;

public interface ProblemsServiceI {

    public boolean checkCorrectAnswer(SubmissionForm submissionForm);

    public ProblemForm create(ProblemForm problemForm);

    public List<ProblemForm> findAll();

    public ProblemForm findOne(String problemId) throws NoSuchElementException;
}
