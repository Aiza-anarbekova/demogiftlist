package com.example.demogiftlist.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Wish wish;
    @ManyToOne
    private User user;
    @ManyToOne
    private Complaint complaint;
    @ManyToOne
    private Gift gift;
}
