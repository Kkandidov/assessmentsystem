package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
public class Test extends EntityAbstract {

    private static final long serialVersionUID = -212766736059791901L;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "topicId", nullable = false)
    private Topic topic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Question> questions;

    public Test() {
    }

    public Test(String name, String description, Topic topic) {
        this.name = name;
        this.description = description;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name) &&
                Objects.equals(description, test.description) &&
                Objects.equals(topic.getId(), test.topic.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, topic.getId());
    }

    @Override
    public String toString() {
        return "Test{" +
                super.toString() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topicId=" + topic.getId() +
                '}';
    }
}
