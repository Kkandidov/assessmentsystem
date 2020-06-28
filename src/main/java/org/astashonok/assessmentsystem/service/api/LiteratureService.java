package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Literature;
import org.astashonok.assessmentsystem.repository.LiteratureRepository;

import java.util.List;

public interface LiteratureService extends LiteratureRepository {

    Literature getById(long id);
    List<Literature> getAll();
}

