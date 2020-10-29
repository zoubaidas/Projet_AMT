package io.zoubaidas.overflowstack.application;

import io.zoubaidas.overflowstack.application.question.QuestionFacade;
import io.zoubaidas.overflowstack.application.user.signinup.LoginAndRegisterFacade;
import io.zoubaidas.overflowstack.infrastructure.persistence.memory.InMemoryQuestionRepository;
import io.zoubaidas.overflowstack.infrastructure.persistence.memory.InMemoryUserRepository;

public class ServiceRegistry {
    private static LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepository());

    private static QuestionFacade questionFacade = new QuestionFacade(new InMemoryQuestionRepository());

    public static LoginAndRegisterFacade getLoginAndRegisterFacade() {
        return loginAndRegisterFacade;
    }


    public static QuestionFacade getQuestionFacade() {
        return questionFacade;
    }

    public ServiceRegistry() {
    }
}
