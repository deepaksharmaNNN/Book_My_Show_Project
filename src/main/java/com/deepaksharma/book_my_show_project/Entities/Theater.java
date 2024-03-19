package com.deepaksharma.book_my_show_project.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String theaterName;

    private String address;

    private Integer noOfScreens;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeats = new ArrayList<>();



}
