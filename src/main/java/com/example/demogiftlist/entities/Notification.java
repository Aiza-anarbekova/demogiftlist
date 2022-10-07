package com.example.demogiftlist.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_date;
    private Boolean seen;

    @OneToOne
    private User requestNoFriend;
    @OneToOne
    private Wish wish;
    @ManyToOne
    private User user;
    @ManyToOne
    private Complaint complaint;
    @OneToOne
    private Gift gift;
}
