package org.astashonok.assessmentsystem.dto.user;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    private long id;
    private String fullName;
    private String login;
    private Set<String> roles;
    private User user;
    private Set<Cabinet> cabinets;

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
        cabinets = new HashSet<>();
        for (String role : this.roles){
            switch (role){
                case "ROLE_USER":
                    cabinets.add(new Cabinet("Пользователь", "/user/home"));
                    break;
                case "ROLE_ADMIN":
                    cabinets.add(new Cabinet("Администратор", "/admin"));
                    break;
                case "ROLE_TUTOR":
                    cabinets.add(new Cabinet("Ментор", "/tutor/home"));
                    break;
            }
        }
    }

    public Set<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(Set<Cabinet> cabinets) {
        this.cabinets = cabinets;
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

    public static class Cabinet{
        private String name;
        private String link;

        public Cabinet(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
