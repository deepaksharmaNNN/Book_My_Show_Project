package com.deepaksharma.book_my_show_project.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String emailId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
