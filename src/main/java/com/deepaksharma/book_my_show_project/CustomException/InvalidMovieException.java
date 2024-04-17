package com.deepaksharma.book_my_show_project.CustomException;

public class InvalidMovieException extends Exception {
    public InvalidMovieException(String message) {
        super(message);
    }
}
