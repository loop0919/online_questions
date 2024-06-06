package jp.te4a.spring.boot.online_questions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.online_questions.bean.ProblemBean;
import jp.te4a.spring.boot.online_questions.form.SubmissionForm;
import jp.te4a.spring.boot.online_questions.repository.ProblemsRepository;

@Service
public class ProblemsService {
    @Autowired
    ProblemsRepository problemsRepository;

    public boolean checkCorrectAnswer(SubmissionForm submissionForm) {
        ProblemBean problemBean = problemsRepository.findById(submissionForm.getProblemId()).orElseThrow();
        return submissionForm.getAnswer().equals(problemBean.getAnswer());
    }

}
