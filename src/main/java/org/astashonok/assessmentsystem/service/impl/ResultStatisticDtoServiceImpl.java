package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.dto.user.ResultStatisticDto;
import org.astashonok.assessmentsystem.service.api.ResultStatisticDtoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("resultStatisticDtoService")
public class ResultStatisticDtoServiceImpl implements ResultStatisticDtoService {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<ResultStatisticDto> getByUserId(long userId) {
        String sql = "CALL getUserFullStatistic(?)";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ResultStatisticDto> list = session.doReturningWork(new ReturningWork<List<ResultStatisticDto>>() {
            List<ResultStatisticDto> resultList = new ArrayList<>();
            ResultStatisticDto resultStatisticDto;

            @Override
            public List<ResultStatisticDto> execute(Connection connection) throws SQLException {
                try (CallableStatement callableStatement = connection.prepareCall(sql)) {
                    callableStatement.setLong(1, userId);
                    ResultSet resultSet = callableStatement.executeQuery();
                    while (resultSet.next()) {
                        resultStatisticDto = new ResultStatisticDto();
                        resultStatisticDto.setUserId(userId);
                        resultStatisticDto.setFullName(resultSet.getString("fullName"));
                        resultStatisticDto.setTestName(resultSet.getString("testName"));
                        resultStatisticDto.setQuestionDescription(resultSet.getString("questionDescription"));
                        resultStatisticDto.setPassedTimes(resultSet.getInt("passedTimes"));
                        resultStatisticDto.setCorrectAnswersPercentage(resultSet.getDouble("correctAnswersPercentage"));
                        resultList.add(resultStatisticDto);
                    }
                    return resultList;
                }
            }
        });
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
