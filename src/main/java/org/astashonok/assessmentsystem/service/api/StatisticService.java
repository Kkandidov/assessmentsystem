package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.repository.StatisticRepository;

import java.util.List;

public interface StatisticService extends StatisticRepository {

    Statistic getById(long id);
    List<Statistic> getAll();
}
