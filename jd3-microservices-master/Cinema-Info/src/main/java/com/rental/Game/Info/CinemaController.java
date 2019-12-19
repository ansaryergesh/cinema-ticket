package com.rental.Game.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    CinemaRepository cinemaRepository;

    @GetMapping
    public String hello() {return "Hello it is cinema page";}

    @PostMapping("/add")
    public Cinema createNote(@Valid @RequestBody Cinema cinema) {return cinemaRepository.save(cinema);}

    @GetMapping("/all")
    public List<Cinema> getAllCinemas() {return cinemaRepository.findAll();}

    @GetMapping("/cinemas/{id}")
    public Cinema getCinemaById(@PathVariable(value="id") Long cinemaID)
            throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaID)
                .orElseThrow(() -> new ResourceNotFoundException("cinema with that id not found ::" + cinemaID));
        return cinema;
    }

    @PutMapping("/cinema/{id}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable(value = "id") Long cinemaID,
                                               @Valid @RequestBody Cinema cinemaDetails) throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaID)
                .orElseThrow(() -> new ResourceNotFoundException("cinema with that id not found ::" + cinemaID));

        cinema.setCinema(cinemaDetails.getCinema());
        cinema.setCity(cinemaDetails.getCity());
        cinema.setDescription(cinemaDetails.getDescription());
        final Cinema updateCinema = cinemaRepository.save(cinema);
        return ResponseEntity.ok(updateCinema);
    }

    @DeleteMapping("/cinemas/{id}")
    public Map<String, Boolean> deleteCinema(@PathVariable(value="id") Long cinemaID)
            throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaID)
            .orElseThrow(() -> new ResourceNotFoundException("cinema with that id not found ::" + cinemaID));

        cinemaRepository.delete(cinema);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
