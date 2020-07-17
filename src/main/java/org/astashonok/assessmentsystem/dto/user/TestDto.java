package org.astashonok.assessmentsystem.dto.user;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Statistic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDto {

    private long id;
    private List<Question> questions;
    private List<Statistic> statistics;
    private int questionCounter;
    private int numberQuestions;
    private SequenceSelector sequenceSelector = new SequenceSelector();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        this.numberQuestions = questions.size();
        this.questionCounter = 0;
        this.statistics = new ArrayList<>();
        for (int i = 0; i < this.numberQuestions; i++) {
            Statistic s = new Statistic();
            s.setQuestion(this.questions.get(i));
            this.statistics.add(s);
        }
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public SequenceSelector iterator() {
        return this.sequenceSelector;
    }

    public class SequenceSelector implements Iterator<Question> {

        @Override
        public boolean hasNext() {
            return questions != null && questionCounter < numberQuestions;
        }

        @Override
        public Question next() {
            return questions.get(questionCounter++);
        }

        public int questionCounterIncrement() {
            return questionCounter++;
        }

        public void clearData(){
            questions = null;
            statistics = null;
            questionCounter = 0;
            numberQuestions = 0;
        }
    }

}
