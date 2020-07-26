package org.astashonok.assessmentsystem.model;

import org.astashonok.assessmentsystem.model.abstracts.EntityAbstract;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends EntityAbstract {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String nameRole;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Statistic> statistic;

    public User() {
    }

    public User(String firstName, String lastName, String login, String password, Role... roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roles = new HashSet<>();
        this.roles.addAll(Arrays.asList(roles));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role setRoleByNameRole(String nameRole){
        Role roleByNameRole = new Role();
        if(nameRole.contains("ADMIN")){
            roleByNameRole.setId(1);
            roleByNameRole.setName(RoleName.ROLE_ADMIN);
        }else if(nameRole.contains("USER")){
            roleByNameRole.setId(3);
            roleByNameRole.setName(RoleName.ROLE_USER);
        }else{
            roleByNameRole.setId(2);
            roleByNameRole.setName(RoleName.ROLE_TUTOR);
        }
        return roleByNameRole;
    }

    public String getFIO(){
        return lastName+" "+firstName;
    }

    public String getNameRole() {
        if (getRoles() != null) {
            StringBuilder builder = new StringBuilder();
            for (Role r : getRoles()) {
                builder.append(r.getName()).append(" ");
            }
            return builder.toString();
        }
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Statistic> getStatistic() {
        return statistic;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role... roles) {
        if(this.roles == null){
            this.roles = new HashSet<>();
        }
        this.roles.addAll(Arrays.asList(roles));
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
