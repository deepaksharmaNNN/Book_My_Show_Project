package com.deepaksharma.book_my_show_project.Services;

import com.deepaksharma.book_my_show_project.Repository.ShowRepository;
import com.deepaksharma.book_my_show_project.RequestDTOs.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public String addShow(AddShowRequest addShowRequest){
        return "Show added successfully";
    }
}
