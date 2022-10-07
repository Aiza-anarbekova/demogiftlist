package com.example.demogiftlist.entities;

import com.example.demogiftlist.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wishes")
@Getter
@Setter
@NoArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String wishName;
    private String linkToGift;
    private LocalDate dateOfHoliday;
    private String description;
    private String image;
    private Status wishStatus;

    @OneToOne
    private User bookingUser;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "wish")
    private List<Complaint> complaints;
    @ManyToOne
    private User user;

    @ManyToOne
    private Holiday holiday;

}
