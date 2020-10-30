package io.zoubaidas.overflowstack.application.question;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AskQuestionCommand {
    private String title;
    private String body;
}
