package com.appinventAsses.MovieApi;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.appinventAsses.MovieApi.Controller.MovieController;
import com.appinventAsses.MovieApi.Dao.MovieRepo;
import com.appinventAsses.MovieApi.Model.Movie;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
class MovieApisApplicationTests {

	   @Autowired
	   private MockMvc mockMvc;
	   
	   @MockBean
	   private MovieRepo movieRepo;

	   @Test
	   @DisplayName("Test findAll()")
	   public void findAllMovies_InputsAreValid_ReturnMovieList() throws Exception {
	      when(movieRepo.findAll()).thenReturn(Arrays.asList(new Movie()));
	      mockMvc.perform(get("/movie/")
	              .accept(MediaType.APPLICATION_JSON))
	              .andExpect(status().isOk());
	      
	      verify(movieRepo,times(1)).findAll();
	   }

	   //Test for movie find by I'd 
	   @Test
	   @DisplayName("Test findById() with invalid movieId")
	   public void findMovieById_WhenIdIsNotPresent_ReturnMovieAsResponse() throws Exception {
	      when(movieRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
	      mockMvc.perform(get("/movie/{id}", 1)
	              .accept(MediaType.APPLICATION_JSON))
	              .andExpect(status().isNotFound());
	      verify(movieRepo,times(1)).findById(Mockito.anyInt());
	   }
	   
	   
	   
}
 
