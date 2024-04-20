package com.deepaksharma.book_my_show_project.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String name;
    private String emailId;
}
