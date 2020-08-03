package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;
import org.astashonok.assessmentsystem.model.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role extends EntityAbstract {

    private static final long serialVersionUID = 471363919705327474L;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(RoleName roleName){
        this.name = roleName.name();
    }

    public String getName() {
        return name;
    }

    public void setName(RoleName roleName) {
        this.name = roleName.name();
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Role{" +
                super.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
