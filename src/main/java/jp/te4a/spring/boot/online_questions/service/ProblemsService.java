package jp.te4a.spring.boot.online_questions.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.aspectj.lang.reflect.NoSuchAdviceException;

import jp.te4a.spring.boot.online_questions.form.ProblemForm;
import jp.te4a.spring.boot.online_questions.form.SubmissionForm;

public interface ProblemsService {

    public boolean checkCorrectAnswer(SubmissionForm submissionForm);

    public ProblemForm create(ProblemForm problemForm);

    public ProblemForm update(ProblemForm problemForm);

    public void deleteById(String problemId);

    public List<ProblemForm> findAll();

    public ProblemForm findOne(String problemId) throws NoSuchElementException;

    public ProblemForm findOneEncoded(String problemId) throws NoSuchAdviceException;
}
