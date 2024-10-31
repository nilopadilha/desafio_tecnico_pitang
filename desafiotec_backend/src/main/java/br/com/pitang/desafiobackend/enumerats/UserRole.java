package br.com.pitang.desafiobackend.enumerats;

public enum UserRole {
    USER("user"),
    ADMIN("admin"),
    GESTOR("gestor");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
