package com.java.course.service;


import com.java.course.model.Question;
import com.java.course.service.impl.JavaQuestionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Collection;


public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");

        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertTrue(actual.contains(new Question("вопрос1", "ответ1")));
        Assertions.assertTrue(actual.contains(new Question("вопрос2", "ответ2")));
    }

    @Test
    void remove() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");

        Collection<Question> actual = javaQuestionService.getAll();

        javaQuestionService.remove(new Question("вопрос1", "ответ1"));
        Assertions.assertEquals(1, actual.size());
        Assertions.assertFalse(actual.contains(new Question("вопрос1", "ответ1")));
    }


}
