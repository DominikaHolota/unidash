package com.unidash.unidash.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
