package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.model.admin.ViewStatistic;
import org.astashonok.assessmentsystem.model.admin.ViewStatisticUserTest;
import org.astashonok.assessmentsystem.repository.StatisticRepository;

import java.util.Date;
import java.util.List;

public interface StatisticService extends StatisticRepository {

    Statistic getById(long id);
    List<Statistic> getAll();
    List<Statistic> getUserStatisticByUserIdAndDate(long id, Date startDate, Date endDate);
    ViewStatistic getQuestionInfo(Question question);
    List<ViewStatistic> getQuestionStatisticList();
    List<ViewStatistic> getTestStatisticList();
    ViewStatistic getTestInfo(Test test);
    List<ViewStatisticUserTest> getUserTestStatisticList();
}
