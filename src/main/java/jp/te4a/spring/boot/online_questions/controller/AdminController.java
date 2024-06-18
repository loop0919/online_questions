package jp.te4a.spring.boot.online_questions.controller;

import org.springframework.beans.BeanUtils;
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
    String problem(@ModelAttribute("problemForm") ProblemForm form, Model model) {
        model.addAttribute("isDisabled", false);
        return "/admin/problem";
    }

    @GetMapping(path="problem/{problemId}")
    String problemUpdate(@ModelAttribute("problemForm") ProblemForm form, @PathVariable String problemId, Model model) {
        var problemBean = problemsService.findOne(problemId);
        BeanUtils.copyProperties(problemBean, form);
        model.addAttribute("problemForm", form);
        model.addAttribute("isDisabled", true);
        return "/admin/problem_update";
    }

    @PostMapping(path="problem/create")
    String create(@Validated @ModelAttribute("problemForm") ProblemForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return problem(form, model);
        }

        problemsService.create(form);
        return "redirect:/problems";
    }

    @PostMapping(path="problem/{problemId}/update")
    String update(@Validated @ModelAttribute("problemForm") ProblemForm form, BindingResult result, @PathVariable String problemId, Model model) {
        if (result.hasErrors()) {
            return problemUpdate(form, problemId, model);
        }

        problemsService.update(form);
        return "redirect:/problems/" + problemId;
    }

    @PostMapping(path="problem/{problemId}/delete")
    String delete(@Validated @ModelAttribute("problemForm") ProblemForm form, BindingResult result, @PathVariable String problemId, Model model) {
        if (result.hasErrors()) {
            return problemUpdate(form, problemId, model);
        }

        problemsService.deleteById(problemId);
        return "redirect:/problems";
    }
}
