package com.example.coursework2.Service;

import com.example.coursework2.Entity.Question;
import com.example.coursework2.Exception.MethodNotAllowedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number1 = random.nextInt(20);
        int number2 = random.nextInt(20);
        int operator = random.nextInt(4);
        String question;
        int answer;
        switch (operator) {
            case 0:
                question = number1 + " + " + number2 + " = ?";
                answer = number1 + number2;
                break;
            case 1:
                question = number1 + " - " + number2 + " = ?";
                answer = number1 - number2;
                break;
            case 2:
                question = number1 + " * " + number2 + " = ?";
                answer = number1 * number2;
                break;
            case 3:
                question = number1 * number2 + " / " + number2 + " = ?";
                answer = number1;
                break;
            default:
                throw new RuntimeException("Такого оператора нет.");
        }
        return new Question(question, String.valueOf(answer));
    }
}
