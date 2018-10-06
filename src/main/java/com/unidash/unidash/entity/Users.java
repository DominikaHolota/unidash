package com.unidash.unidash.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Data
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    @Pattern(regexp = "student|teacher|admin", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String role;
    @NotEmpty
    @Column(nullable = false)
    @Email(message = "*Wpisz prawidłowy adres e-mail")
    private String email;
    @NotEmpty
    @Column(nullable = false)
    private String password;
    @NotEmpty
    @Column(nullable = false)
    private String name;
    @NotEmpty
    @Column(nullable = false)
    private String lastname;
    @NotEmpty
    @Column(nullable = false)
    private boolean isActive;


}
