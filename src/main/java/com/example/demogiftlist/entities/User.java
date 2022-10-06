package com.example.demogiftlist.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Boolean isBlock;
    private String photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Wish> wishes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Gift> gifts;
    @ManyToOne
    private Charity charity;
    @OneToMany
    private List<User> friends;
    @OneToMany
    private List<User> requests;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Holiday> holidays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Notification> notifications;
    @OneToOne
    private UserInfo userInfo;

}
