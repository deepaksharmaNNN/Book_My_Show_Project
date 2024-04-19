package com.deepaksharma.book_my_show_project.RequestDTOs;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequest {
    public int showId;
    public List<String> seatList;
}
