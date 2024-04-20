package com.deepaksharma.book_my_show_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String seatNumbersBooked;

    private Integer totalAmountPaid;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Show show;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private User user;
}
