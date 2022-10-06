package com.example.demogiftlist.entities;

import com.example.demogiftlist.enums.ClothingSize;
import com.example.demogiftlist.enums.ShoeSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String country;
    private String phoneNumber;
    private LocalDate dateOfFirst;
    private ShoeSize shoeSize;
    private ClothingSize clothingSize;
    private String hobby;
    private String important;
    private String facebook;
    private String instagram;
    private String telegram;
    private String vk;


}
