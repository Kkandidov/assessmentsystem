package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class Question extends EntityAbstract {

    private static final long serialVersionUID = -2751224412459986012L;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "testId", nullable = false)
    private Test test;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Answer> answers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Literature> literature;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Statistic> statistics;

    public Question() {
    }

    public Question(String description, Test test) {
        this.description = description;
        this.test = test;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public Set<Literature> getLiterature() {
        return literature;
    }

    public Set<Statistic> getStatistics() {
        return statistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(description, question.description) &&
                Objects.equals(test.getId(), question.test.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, test.getId());
    }

    @Override
    public String toString() {
        return "Question{" +
                super.toString() +
                ", description='" + description + '\'' +
                ", testId=" + test.getId() +
                '}';
    }
}
