package jp.te4a.spring.boot.online_questions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping(path="/problems")
public class ProblemsController {

    @GetMapping
    public String index(Model model) {
        return "problems/index";
    }
    
    @GetMapping(path="/{problemId}")
    public String problem(Model model, @PathVariable String problemId) {
        return "problems/" + problemId;
    }
}
