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
public class Literature extends EntityAbstract {

    private static final long serialVersionUID = 218407080623072886L;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "literature")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Link> links;

    public Literature() {
    }

    public Literature(String description, Question question) {
        this.description = description;
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<Link> getLinks() {
        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Literature that = (Literature) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(question.getId(), that.question.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, question.getId());
    }

    @Override
    public String toString() {
        return "Literature{" +
                super.toString() +
                ", description='" + description + '\'' +
                ", questionId=" + question.getId() +
                '}';
    }
}
