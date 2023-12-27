package com.java.course.service.impl;

import com.java.course.exceptions.QuestionAlreadyExistException;
import com.java.course.exceptions.QuestionNotFoundException;
import com.java.course.exceptions.StorageIsEmpty;
import com.java.course.model.Question;
import com.java.course.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private static final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionAlreadyExistException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new StorageIsEmpty();
        }
        int index = random.nextInt(questions.size());

        return questions.stream()
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
