package com.appinventAsses.MovieApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appinventAsses.MovieApi.Model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{
            
}
