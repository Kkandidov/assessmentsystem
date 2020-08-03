package org.astashonok.assessmentsystem.model.abstracts;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityAbstract implements Serializable {

    private static final long serialVersionUID = 1482512542062888232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected EntityAbstract() {
    }

    protected EntityAbstract(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
