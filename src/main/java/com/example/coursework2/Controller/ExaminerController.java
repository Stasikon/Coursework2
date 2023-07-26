package com.example.coursework2.Controller;

import com.example.coursework2.Entity.Question;
import com.example.coursework2.Service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExaminerController {

    public final ExaminerServiceImpl service;

    public ExaminerController(ExaminerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount) {
        return service.getQuestions(amount);
    }
}