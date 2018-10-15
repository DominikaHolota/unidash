package com.unidash.unidash.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;
    private int fosId;
    private int grouID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getFosId() {
        return fosId;
    }

    public void setFosId(int fosId) {
        this.fosId = fosId;
    }

    public int getGrouID() {
        return grouID;
    }

    public void setGrouID(int grouID) {
        this.grouID = grouID;
    }


}
