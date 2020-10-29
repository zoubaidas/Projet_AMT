package io.zoubaidas.overflowstack.domain.question;

import io.zoubaidas.overflowstack.domain.IEntity;
import io.zoubaidas.overflowstack.domain.user.User;
import io.zoubaidas.overflowstack.domain.user.UserId;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Question implements IEntity<Question, QuestionId> {
    private QuestionId id;
    private UserId authorId;
    private String title;
    private String body;
    private LocalDateTime createdOn;

    @Override
    public Question deepClone() {
        return this.toBuilder()
                .id(new QuestionId(id.asString()))
                .build();
    }

    public static class QuestionBuilder {
        public Question build() {
            if (id == null) {
                id = new QuestionId();
            }
            if (authorId == null) {
                throw new IllegalArgumentException("Login is required");
            }
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("Title is required");
            }
            if (body == null || body.isEmpty()) {
                throw new IllegalArgumentException("Empty question");
            }
            if (createdOn == null) {
                createdOn = LocalDateTime.now();
            }
            return new Question(id, authorId, title, body, createdOn);
        }
    }
}
