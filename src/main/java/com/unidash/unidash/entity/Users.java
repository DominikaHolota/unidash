package com.unidash.unidash.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String login;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Column(nullable = false)
    private String lastname;
    @NotBlank
    @Column(nullable = false)
    private char role;
    @NotBlank
    @Column(nullable = false)
    private boolean isActive;
    @NotBlank
    @Column(nullable = false)
    private String password;

    public Users() {
    }

    public Users(@NotBlank String login, @NotBlank String name, @NotBlank String lastname, @NotBlank char role, @NotBlank boolean isActive, @NotBlank String password) {
        this.login = login;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.isActive = isActive;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
