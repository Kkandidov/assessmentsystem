package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.repository.AnswerRepository;

import java.util.List;

public interface AnswerService extends AnswerRepository {

    Answer getById(long id);
    List<Answer> getAll();
    List<Answer> getByQuestionId(long id);
}