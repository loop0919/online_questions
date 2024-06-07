package jp.te4a.spring.boot.online_questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import jp.te4a.spring.boot.online_questions.form.ProblemForm;
import jp.te4a.spring.boot.online_questions.service.ProblemsService;

@Controller
@RequestMapping(path="admin")
public class AdminController {
    @Autowired
    ProblemsService problemsService;
    
    @ModelAttribute
    ProblemForm setUpForm() {
        return new ProblemForm();
    }

    @GetMapping(path="problem")
    String problem(@ModelAttribute("problemForm") ProblemForm form) {
        return "/admin/problem";
    }

    @PostMapping(path="problem/create")
    String create(@Valid @ModelAttribute("problemForm") ProblemForm form, BindingResult result) {
        if (result.hasErrors()) {
            return problem(form);
        }

        problemsService.create(form);
        return "redirect:/problems";
    }

}
