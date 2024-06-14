package jp.te4a.spring.boot.online_questions.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.online_questions.bean.ProblemBean;
import jp.te4a.spring.boot.online_questions.component.Html;
import jp.te4a.spring.boot.online_questions.form.ProblemForm;
import jp.te4a.spring.boot.online_questions.form.SubmissionForm;
import jp.te4a.spring.boot.online_questions.repository.ProblemsRepository;
import jp.te4a.spring.boot.online_questions.service.ProblemsService;

@Service
public class ProblemsServiceImpl implements ProblemsService{
    @Autowired
    ProblemsRepository problemsRepository;

    public boolean checkCorrectAnswer(SubmissionForm submissionForm) {
        ProblemBean problemBean = problemsRepository.findById(submissionForm.getProblemId()).orElseThrow();
        return problemBean.getAnswer().equals(submissionForm.getAnswer());
    }

    public ProblemForm create(ProblemForm problemForm) {
        var problemBean = new ProblemBean();

        BeanUtils.copyProperties(problemForm, problemBean);
        problemsRepository.save(problemBean);
        return problemForm;
    }

    public List<ProblemForm> findAll() {
        List<ProblemForm> formList = problemsRepository.findAll()
                .stream()
                .map(bean -> {
                    var form = new ProblemForm();
                    BeanUtils.copyProperties(bean, form);
                    form.setProblemStatement(Html.toHtml(bean.getProblemStatement()));
                    return form;
                })
                .collect(Collectors.toList());
        
        return formList;
    }

    public ProblemForm findOne(String problemId) throws NoSuchElementException {
        var problemBean = problemsRepository.findById(problemId).orElseThrow(NoSuchElementException::new);
        var problemForm = new ProblemForm();
        BeanUtils.copyProperties(problemBean, problemForm);
        problemForm.setProblemStatement(Html.toHtml(problemBean.getProblemStatement()));

        return problemForm;
    }

}
