package com.deepaksharma.book_my_show_project.Entities;

import com.deepaksharma.book_my_show_project.Enums.SeatType;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theater_seats")
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private Integer seatNumber;

    private SeatType seatType;

}
