package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.model.admin.ViewStatistic;
import org.astashonok.assessmentsystem.model.admin.ViewStatisticUserTest;
import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.RootGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

    private SessionFactory sessionFactory;

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

    @Override
    @Transactional
    public Statistic getById(long id) {
        return getById(Statistic.class, id);
    }

    @Override
    @Transactional
    public List<Statistic> getAll() {
        return getAll(Statistic.class);
    }

    @Override
    @Transactional
    public List<Statistic> getUserStatisticByUserIdAndDate(long id, Date startDate, Date endDate) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        RootGraph<?> graph = session.getEntityGraph("graph.statistic");
        List<Statistic> statistics = session
                .createQuery("FROM Statistic WHERE user.id = :id AND date between :startDate AND :endDate", Statistic.class)
                .setParameter("id", id)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setHint("javax.persistence.fetchgraph", graph)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return statistics;

//        fetch without collection initialization

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        RootGraph<?> graph = session.createEntityGraph("graph.statistic");
//        List<Statistic> statistics = session
//                .createSQLQuery("CALL getUserStatistic(:user_id, :startDate, :endDate)")
//                .addEntity(Statistic.class)
//                .setParameter("user_id", id)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setHint("javax.persistence.fetchgraph", graph)
//                .getResultList();
//        session.getTransaction().commit();
//        return statistics;

//        or
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        List<Statistic> statistics = session
//                .createStoredProcedureQuery("GetUserStatistic", Statistic.class)
//                .registerStoredProcedureParameter(0, Long.class, ParameterMode.IN)
//                .registerStoredProcedureParameter(1, Date.class, ParameterMode.IN)
//                .registerStoredProcedureParameter(2, Date.class, ParameterMode.IN)
//                .setParameter(0, id)
//                .setParameter(1, startDate)
//                .setParameter(2, endDate)
//                .getResultList();
//        session.getTransaction().commit();
//        return statistics;
    }

    @Override
    public ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;
        List<Statistic> statisticList = getAllStatisticByQuestionId(question.getId());
        if (!(statisticList.isEmpty())) {
            int numberOfTimes = statisticList.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : statisticList
            ) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            if(numberOfTimes!=0){
                viewStatistic = new ViewStatistic(question.getDescription(), numberOfTimes, (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));}
            else{
                viewStatistic = new ViewStatistic(question.getDescription(),0,0);
            }
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }

    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> questionList = questionService.getAll();
        for (Question question : questionList
        ) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionInfoList.add(viewStatistic);
            }
        }
        questionInfoList.sort(Comparator.comparing(ViewStatistic::getNameQuestion));
        return questionInfoList;
    }

    @Override
    public ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        List<Statistic> statisticList = getFilteredStatisticByTestId(test.getId());
        if (!statisticList.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int numberOfTimes = statisticList.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : statisticList
            ) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            viewStatistic = new ViewStatistic(test.getName(), numberOfTimes / numberOfQuestionInTest, (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }


    public List<ViewStatistic> getTestStatisticList() {
        List<ViewStatistic> testInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Test> testList = testService.getAll();
        for (Test test : testList
        ) {
            viewStatistic = getTestInfo(test);
            if (viewStatistic != null) {
                testInfoList.add(viewStatistic);
            }
        }
        testInfoList.sort(Comparator.comparing(ViewStatistic::getNameQuestion));
        return testInfoList;
    }

    private ViewStatisticUserTest getUserTestInfo(Statistic statistic) {
        ViewStatisticUserTest viewStatisticUserTest = null;
        List<Statistic> statisticList = getFilteredStatisticByTestUser(statistic);
        int countOfCorrectAnswers = 0;
        int numberOfAllQuestion = statisticList.size();
        int numberOfTimes = (int) Math.ceil((double)statisticList.size()/getQuestionInTest(statistic));
        if (!statisticList.isEmpty()) {
            for (Statistic st : statisticList
            ) {
                if (st.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            if(numberOfTimes==0){
                viewStatisticUserTest = null;
            }else {
                viewStatisticUserTest = new ViewStatisticUserTest(statistic.getUser().getFIO(),
                        statistic.getQuestion().getTest().getName(), numberOfTimes, (int) Math.round(((double) countOfCorrectAnswers) / numberOfAllQuestion * 100));
            }
        } else {
            viewStatisticUserTest = null;
        }

        return viewStatisticUserTest;
    }

    @Override
    public List<ViewStatisticUserTest> getUserTestStatisticList() {
        List<ViewStatisticUserTest> userTestInfoList = new ArrayList<>();
        ViewStatisticUserTest viewStatisticUserTest;
        for (Statistic statistic : getAll()
        ) {
            viewStatisticUserTest = getUserTestInfo(statistic);
            if (viewStatisticUserTest != null) {
                userTestInfoList.add(viewStatisticUserTest);
            }
        }
        Set<ViewStatisticUserTest> set = new HashSet<>(userTestInfoList);
        set.addAll(userTestInfoList);
        userTestInfoList.clear();
        userTestInfoList.addAll(set);
        userTestInfoList.sort(Comparator.comparing(ViewStatisticUserTest::getFIO));
        return userTestInfoList;
    }
}
