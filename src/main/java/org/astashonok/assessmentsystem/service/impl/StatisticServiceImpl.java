package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.RootGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

    private SessionFactory sessionFactory;

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
        System.out.println("id ---------------- " + id);
        System.out.println("startDate --------- " + startDate);
        System.out.println("endDate ----------- " + endDate);
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
}
