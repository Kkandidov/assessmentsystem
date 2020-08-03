package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic> {
    default List<Statistic> getAllStatisticByQuestionId(long questionId){
        return getBeanToBeAutowired()
                .getCurrentSession()
                .createQuery("from Statistic where question.id="+questionId).list();
    };
    default List<Statistic> getFilteredStatisticByTestId(long testId){
        List<Statistic> statisticList = new ArrayList<>();
        List<Long> questions = getBeanToBeAutowired()
                .getCurrentSession()
                .createQuery("select id from Question where test.id="+testId).list();
        for (Long id:questions
        ) {
            statisticList.addAll(getBeanToBeAutowired()
                    .getCurrentSession()
                    .createQuery("from Statistic where question.id="+id).list());
        }
        return statisticList;
    };

    default List<Statistic> getFilteredStatisticByTestUser(Statistic statistic){
        List<Long> questionId = getBeanToBeAutowired()
                .getCurrentSession()
                .createQuery("select id from Question where test.id="+statistic.getQuestion().getTest().getId())
                .list();

        List<Statistic> list =new ArrayList<>();
        for (Long l:questionId
        ) {
            list.addAll(getBeanToBeAutowired()
                    .getCurrentSession()
                    .createQuery("from Statistic  where user.id="+statistic.getUser().getId()+" and question.id="+l)
                    .list());
        };
        return list;
    }
    default Integer getQuestionInTest(Statistic statistic){
        int questionInTest;
        List<Long> questionId = getBeanToBeAutowired()
                .getCurrentSession()
                .createQuery("select id from Question where test.id="+statistic.getQuestion().getTest().getId())
                .list();
        questionInTest = questionId.size();
        return questionInTest;
    }
}
