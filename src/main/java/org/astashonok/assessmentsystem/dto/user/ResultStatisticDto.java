package org.astashonok.assessmentsystem.dto.user;

import java.io.Serializable;

public class ResultStatisticDto implements Serializable {

    private static final long serialVersionUID = -8291425780586748951L;

    long userId;
    String fullName;
    String testName;
    String questionDescription;
    int passedTimes;
    double correctAnswersPercentage;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public int getPassedTimes() {
        return passedTimes;
    }

    public void setPassedTimes(int passedTimes) {
        this.passedTimes = passedTimes;
    }

    public double getCorrectAnswersPercentage() {
        return correctAnswersPercentage;
    }

    public void setCorrectAnswersPercentage(double correctAnswersPercentage) {
        this.correctAnswersPercentage = correctAnswersPercentage;
    }

    @Override
    public String toString() {
        return "ResultStatisticDto{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", testName='" + testName + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", passedTimes=" + passedTimes +
                ", correctAnswersPercentage=" + correctAnswersPercentage +
                '}';
    }
}
