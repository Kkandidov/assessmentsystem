package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question> {
    default List<String> getNamesQuestions(){
        List<String> namesQuestionsL = new ArrayList<>();
        for (Question t:getAll(Question.class)
        ) {
            namesQuestionsL.add(t.getDescription());
        }
        return namesQuestionsL;
    }
}
