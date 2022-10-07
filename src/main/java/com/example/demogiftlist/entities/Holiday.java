package com.example.demogiftlist.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "holidays")
@Getter
@Setter
@NoArgsConstructor
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private LocalDate dateOfHoliday;
    private String image;
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "holiday")
    private List<Wish> wishes;
}
