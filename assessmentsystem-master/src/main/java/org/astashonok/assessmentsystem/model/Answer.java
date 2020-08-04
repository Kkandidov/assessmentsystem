package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class Answer extends EntityAbstract {

    private static final long serialVersionUID = 5909618494137826561L;
    private String description;
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    public Answer() {
    }

    public Answer(String description, boolean correct, Question question) {
        this.description = description;
        this.correct = correct;
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return correct == answer.correct &&
                Objects.equals(description, answer.description) &&
                Objects.equals(question.getId(), answer.question.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, correct, question.getId());
    }

    @Override
    public String toString() {
        return "Answer{" +
                super.toString() +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                ", questionId=" + question.getId() +
                '}';
    }
}
