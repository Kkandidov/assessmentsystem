package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.repository.QuestionRepository;

import java.util.List;

public interface QuestionService extends QuestionRepository {

    Question getById(long id);
    List<Question> getAll();
    List<Question> getByTestId(long id);
}
