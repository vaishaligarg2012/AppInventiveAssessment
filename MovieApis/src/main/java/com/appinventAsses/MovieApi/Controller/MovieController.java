package com.appinventAsses.MovieApi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appinventAsses.MovieApi.Dao.MovieRepo;
import com.appinventAsses.MovieApi.Model.Movie;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	 @Autowired
	 MovieRepo movieRepo;

	 @GetMapping("/")
	public List<Movie> getMovies() {
        return  movieRepo.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) throws Exception {
    	Optional<Movie> movie = movieRepo.findById(id);

    	if (!movie.isPresent())
    		throw new Exception("id-" + id);

    	return movie.get();
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
        Movie savedMovie = movieRepo.save(movie);

    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(savedMovie.getId()).toUri();

    	return ResponseEntity.created(location).build();
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<Object>  update(@RequestBody Movie movie, @PathVariable int id){
    	Optional<Movie> movieOptional = movieRepo.findById(id);

    	if (!movieOptional.isPresent())
    		return ResponseEntity.notFound().build();

    	movie.setId(id);
    	
    	movieRepo.save(movie);

    	return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
    	   movieRepo.deleteById(id);
    }

   
}
