package jp.te4a.spring.boot.online_questions.controller;

import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.te4a.spring.boot.online_questions.form.SubmissionForm;
import jp.te4a.spring.boot.online_questions.service.ProblemsService;


@Controller
@RequestMapping(path="/problems")
public class ProblemsController {
    @Autowired
    ProblemsService problemsService;

    @ModelAttribute
    SubmissionForm setUpForm() {
        return new SubmissionForm();
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("problems", problemsService.findAll()); 
        return "problems/index";
    }
    
    @GetMapping(path="/{problemId}")
    public String problem(Model model, @PathVariable String problemId) {
        try {
            model.addAttribute("problem", problemsService.findOneEncoded(problemId));
        } catch (NoSuchAdviceException e) {
            e.printStackTrace();
        }
        return "problems/problem";
    }

    @GetMapping(path="/submissions")
    public String problem(Model model) {
        return "problems/submissions";
    }

    @PostMapping(path="/{problemId}/submit")
    public String submit(Model model, @PathVariable String problemId, @Validated SubmissionForm submissionForm, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/problems/" + problemId + "?re";
        }
        
        if (problemsService.checkCorrectAnswer(submissionForm)) {
            return "redirect:/problems/" + problemId + "?ac";
        } else {
            return "redirect:/problems/" + problemId + "?wa";
        }
    }
}
