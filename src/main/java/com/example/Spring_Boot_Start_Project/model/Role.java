package com.example.Spring_Boot_Start_Project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Role() {
    }

    public Role(Account account, String roleName) {
        this.roleName = roleName;
        this.account = account;

    }
}
