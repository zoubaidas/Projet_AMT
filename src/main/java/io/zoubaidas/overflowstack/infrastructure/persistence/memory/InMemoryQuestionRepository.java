package io.zoubaidas.overflowstack.infrastructure.persistence.memory;

import io.zoubaidas.overflowstack.domain.question.IQuestionRepository;
import io.zoubaidas.overflowstack.domain.question.Question;
import io.zoubaidas.overflowstack.domain.question.QuestionId;

public class InMemoryQuestionRepository extends InMemoryRepository<Question, QuestionId> implements IQuestionRepository {

}
