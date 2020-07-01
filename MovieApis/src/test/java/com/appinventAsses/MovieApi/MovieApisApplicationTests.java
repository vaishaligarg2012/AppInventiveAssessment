package com.appinventAsses.MovieApi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.appinventAsses.MovieApi.Controller.MovieController;
import com.appinventAsses.MovieApi.Model.Movie;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
class MovieApisApplicationTests {

	   @Autowired
	   private MockMvc mvc;
	   @MockBean
	   MovieController movieController;

	@Test 
	void getMovies()  throws Exception {
		List<Movie> movies = movieController.getMovies();
		Movie m  = new Movie();
		System.out.println(movies);
		assertEquals(1, m.getId());
		
	}

}
 