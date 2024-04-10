package com.deepaksharma.book_my_show_project.Transformers;

import com.deepaksharma.book_my_show_project.Entities.Theater;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddTheaterRequest;

public class TheaterTransformer {
    public static Theater convertTheaterRequestToTheaterEntity(AddTheaterRequest addTheaterRequest){
        return Theater.builder()
                .theaterName(addTheaterRequest.getTheaterName())
                .address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens())
                .build();
    }
}
