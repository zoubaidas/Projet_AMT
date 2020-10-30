package io.zoubaidas.overflowstack.application.question;

import io.zoubaidas.overflowstack.domain.question.QuestionId;
import io.zoubaidas.overflowstack.domain.user.UserId;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class QuestionDTO {
    private QuestionId id;
    private String title;
    private String body;
    private UserId authorId;
    private LocalDateTime createdOn;
}
