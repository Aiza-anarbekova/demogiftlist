package com.example.demogiftlist.entities;

import com.example.demogiftlist.enums.Reason;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Wish wish;
    @ManyToOne
    private User complainer;
    private Boolean seen;
    private Reason reasonOfComplaint;
}
