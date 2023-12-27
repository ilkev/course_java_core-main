package com.java.course.service;

import com.java.course.model.Question;
import com.java.course.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private final List<Question> questions = List.of(
            new Question("вопрос", "ответ"),
            new Question("вопрос1", "ответ1"),
            new Question("вопрос2", "ответ2")
    );

    @Test
    void getQuestions(){
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).
                thenReturn(questions.get(0)).
                thenReturn(questions.get(1)).
                thenReturn(questions.get(1)).
                thenReturn(questions.get(1)).
                thenReturn(questions.get(2));

        Collection<Question> actual = examinerService.getQuestions(3);

        Assertions.assertEquals(3,actual.size());
        Assertions.assertTrue(questions.containsAll(actual));
    }

}
