package com.unidash.unidash.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "grades")
public class Grades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    public Grades() {
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId() {

    }

    public double getValue() {
        return value * 0.1;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

}
