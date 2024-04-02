package com.deepaksharma.book_my_show_project.RequestDTOs;

import lombok.Data;

@Data

public class AddTheaterRequest {
    private String theaterName;

    private String address;

    private Integer noOfScreens;
}
