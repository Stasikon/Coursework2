package com.example.coursework2.Service;

import com.example.coursework2.Entity.Question;
import com.example.coursework2.Exception.BadRequestException;
import com.example.coursework2.Repository.JavaQuestionRepository;
import com.example.coursework2.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.questionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question ques = new Question(question, answer);
        questionRepository.add(ques);
        return ques;
    }


    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        Question removeQues = questionRepository.remove(question);
        if (removeQues != null) {
            return question;
        }
        throw new BadRequestException("Question not found");
    }

    @Override
    public Collection<Question> getAll() {
        Collection<Question> getAllQuestionsCollections = questionRepository.getAll();
        if (getAllQuestionsCollections != null) {
            return Collections.unmodifiableCollection(getAllQuestionsCollections);
        }
        return Collections.emptyList();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        if (!questions.isEmpty()) {
            int randomIndex = new Random().nextInt(questions.size());
            return questions.stream().skip(randomIndex).findFirst().orElse(null);
        }
        return null;
    }
}