package com.deepaksharma.book_my_show_project.Repository;

import com.deepaksharma.book_my_show_project.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
