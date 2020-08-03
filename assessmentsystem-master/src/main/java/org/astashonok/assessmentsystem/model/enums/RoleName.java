package org.astashonok.assessmentsystem.model.enums;

public enum RoleName {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_TUTOR("TUTOR");

    private String name;

    RoleName(String name) {
        this.name = name;
    }

    public String getValue(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
