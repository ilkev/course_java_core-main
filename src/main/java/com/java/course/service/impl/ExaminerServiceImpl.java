package com.java.course.service.impl;

import com.java.course.exceptions.QuestionAmountException;
import com.java.course.model.Question;
import com.java.course.service.ExaminerService;
import com.java.course.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    private final QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount> questionService.getAll().size()){
            throw new QuestionAmountException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}
