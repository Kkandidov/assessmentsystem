package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class Link extends EntityAbstract {

    private static final long serialVersionUID = 6494218299043499655L;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "literatureId", nullable = false)
    private Literature literature;

    public Link() {
    }

    public Link(String link, Literature literature) {
        this.link = link;
        this.literature = literature;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return Objects.equals(link, link1.link) &&
                Objects.equals(literature.getId(), link1.literature.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, literature.getId());
    }

    @Override
    public String toString() {
        return "Link{" +
                super.toString() +
                ", link='" + link + '\'' +
                ", literatureId=" + literature.getId() +
                '}';
    }
}
