package com.deepaksharma.book_my_show_project.Entities;

import com.deepaksharma.book_my_show_project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_seats")
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private Integer price;

    private Boolean isAvailable;

    private Boolean foodIncluded;

    private Integer seatNumber;
    //will get these values from mappings;
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Show show;
}
