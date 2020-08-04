package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Link;
import org.astashonok.assessmentsystem.repository.LinkRepository;

import java.util.List;

public interface LinkService extends LinkRepository {

    Link getById(long id);
    List<Link> getAll();
}
