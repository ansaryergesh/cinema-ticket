package com.rent.Rental.System.Api.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rent.Rental.System.Api.Models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieInfoService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getAllMovies_Fallback")
    public List<Movie> getAllMovies() {
        ResponseEntity<List<Movie>> rateResponse =
                restTemplate.exchange("http://localhost:8082/movie/all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
                        });
        List<Movie> rates = rateResponse.getBody();
        return rates;
    }

    @HystrixCommand(fallbackMethod = "getMovies_Fallback")
    public Movie getMovies(Long id) {
        Movie  movie = restTemplate.getForObject(
                "http://localhost:8082/movie/movies/"+id,
                Movie.class);
        return movie;
    }

    @SuppressWarnings("unused")
    private List<Movie> getAllMovies_Fallback() {

        System.out.println("Movie Service is down!!! fallback route enabled...");
        List<Movie> list =  Arrays.asList(
                new Movie("NULL","NULL","NULL","NULL","NULL", null,"null"));
        return list;
//        return "CIRCUIT BREAKER ENABLED!!! No Response From Game Service at this moment. " +
//                " Service will be back shortly - " + new Date();
    }
    @SuppressWarnings("unused")
    private Movie getMovies_Fallback(Long id) {

        System.out.println("Movie Service is down!!! fallback route enabled...");
        Movie list=new Movie("NULL","NULL","NULL","NULL","NULL",null, "null");
        return list;
    }



    @HystrixCommand(fallbackMethod = "addMovies_Fallback")
    public Movie createNote(  Movie movie) {
        return restTemplate.postForObject("http://localhost:8082/movie/add",
                movie, Movie.class);
    }


    @SuppressWarnings("unused")
    public Movie addMovies_Fallback(  Movie movie) {
        System.out.println("Movie Service is down!!! fallback route enabled...");
        Movie list = movie;
        return  list;
    }

    @HystrixCommand(fallbackMethod = "deleteMovies_Fallback")
    public Boolean delete(String id) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8082/movies/"+id, params);
        return true;
    }

    @SuppressWarnings("unused")
    public Boolean deleteMovies_Fallback(String id) {
        return false;
    }

    @HystrixCommand(fallbackMethod = "updateMovies_Fallback")
    public Movie updateMovie( String movieID, Movie movieDetails) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", movieID);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8082/movie/movie/"+movieID, movieDetails, params);
        return movieDetails;
    }
    @SuppressWarnings("unused")
    public Movie updateMovies_Fallback( String movieID, Movie movieDetails) {
        System.out.println("Movie Service is down!!! fallback route enabled...");
        return new Movie("NULL","NULL","NULL","NULL","NULL", null,"null");
    }



}
