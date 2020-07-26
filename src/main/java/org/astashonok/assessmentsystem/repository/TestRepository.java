package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TestRepository extends CrudRepository<Test> {
    default List<String> getNamesTests(){
        List<String> namesTestsL = new ArrayList<>();
        for (Test t:getAll(Test.class)
        ) {
            namesTestsL.add(t.getName());
        }
        return namesTestsL;
    }
}
