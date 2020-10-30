package io.zoubaidas.overflowstack.application.question;

import io.zoubaidas.overflowstack.domain.question.IQuestionRepository;
import io.zoubaidas.overflowstack.domain.question.Question;
import io.zoubaidas.overflowstack.domain.user.UserId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionFacade {

    private IQuestionRepository questionRepository;

    public QuestionFacade(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public void submitQuestion(AskQuestionCommand command, UserId authorId) {
        Question question = Question.builder()
                .authorId(authorId)
                .title(command.getTitle())
                .body(command.getBody())
                .build();
        questionRepository.save(question);
    }

    public Collection<QuestionDTO> listQuestions() {
        Collection<Question> questionCollection = questionRepository.findAll();
        Collection<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questionCollection) {
            questionDTOS.add(QuestionDTO.builder()
                    .title(question.getTitle())
                    .authorId(question.getAuthorId())
                    .body(question.getBody())
                    .createdOn(question.getCreatedOn())
                    .id(question.getId())
                    .build());
        }
        return questionDTOS;
    }
}
