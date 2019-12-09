package com.rental.Game.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    public String hello(){
        return "Hello, It's info page";
    }

    @PostMapping("/add")
    public Movie createNote(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/all")
    public List<Movie> getAllGames() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getGameById(@PathVariable(value = "id") Long movieID)
            throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieID)
                .orElseThrow(() -> new ResourceNotFoundException("movie not found for this id :: " + movieID));
        return movie;
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateGame(@PathVariable(value = "id") Long movieID,
                                            @Valid @RequestBody Movie movieDetails) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieID)
                .orElseThrow(() -> new ResourceNotFoundException("movie not found for this id :: " + movieID));

        movie.setName(movieDetails.getName());
        movie.setJanre(movieDetails.getJanre());
        movie.setDescription(movieDetails.getDescription());
        movie.setCinema(movieDetails.getCinema());
        movie.setPrice(movieDetails.getPrice());
        final Movie updatedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(updatedMovie);
    }
    @DeleteMapping("/movies/{id}")
    public Map<String, Boolean> deleteGame(@PathVariable(value = "id") Long movieID)
            throws ResourceNotFoundException {
        Movie game = movieRepository.findById(movieID)
                .orElseThrow(() -> new ResourceNotFoundException("movie not found for this id :: " + movieID));

        movieRepository.delete(game);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
