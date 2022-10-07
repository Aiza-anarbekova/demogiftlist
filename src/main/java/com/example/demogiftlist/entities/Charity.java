package com.example.demogiftlist.entities;

import com.example.demogiftlist.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "charity")
@Getter
@Setter
@NoArgsConstructor
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User reservoir;
    @ManyToOne
    private User user;
    @Enumerated
    private Status charityStatus;


}
