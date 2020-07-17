package org.astashonok.assessmentsystem.dto.user;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    private long id;
    private String fullName;
    private String login;
    private Set<String> roles;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", roles=" + roles +
                '}';
    }
}
