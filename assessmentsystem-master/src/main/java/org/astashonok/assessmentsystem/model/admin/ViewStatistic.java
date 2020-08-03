package org.astashonok.assessmentsystem.model.admin;

public class ViewStatistic {

    private String nameQuestion;
    private Integer totalCompleted;
    private Integer percentCorrectAnswers;

    public ViewStatistic(String nameQuestion, Integer totalCompleted, Integer percentCorrectAnswers) {
        this.nameQuestion = nameQuestion;
        this.totalCompleted = totalCompleted;
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    public ViewStatistic() {
    }

    public ViewStatistic(String nameQuestion, Integer totalCompleted) {
        this.nameQuestion = nameQuestion;
        this.totalCompleted = totalCompleted;
    }

    public String getNameQuestion() {
        return nameQuestion;
    }

    public void setNameQuestion(String nameQuestion) {
        this.nameQuestion = nameQuestion;
    }

    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public Integer getPercentCorrectAnswers() {
        return percentCorrectAnswers;
    }

    public void setPercentCorrectAnswers(Integer percentCorrectAnswers) {
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    @Override
    public String
    toString() {
        return "ViewStatistic{" +
                "nameQuestion='" + nameQuestion + '\'' +
                ", totalCompleted=" + totalCompleted +
                ", percentCorrectAnswers=" + percentCorrectAnswers +
                '}';
    }
}
