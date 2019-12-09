package com.rent.Renting.Service;

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
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public String hello(){
        return "Hello, It's booking page";
    }

    @GetMapping("/all")
    public List<Booking> allBooking(){
        return bookingRepository.findAll();
    }
    @PostMapping("/add")
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
    @GetMapping("/bookingtickets/{id}")
    public Booking getBookingById(@PathVariable(value = "id") Long bookingID)
            throws ResourceNotFoundException {
        Booking booking = bookingRepository.findById(bookingID)
                .orElseThrow(() -> new ResourceNotFoundException("booking not found for this id :: " + bookingID));
        return booking;
    }
    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") Long gameID,
                                              @Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
        Booking booking = bookingRepository.findById(gameID)
                .orElseThrow(() -> new ResourceNotFoundException("booking not found for this id :: " + gameID));

        booking.setMovieID(bookingDetails.getMovieID());
        booking.setPrice(bookingDetails.getPrice());
        booking.setDate(bookingDetails.getDate());
        booking.setCinema(bookingDetails.getCinema());
        booking.setUserID(bookingDetails.getUserID());
        final Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/bookings/{id}")
    public Map<String, Boolean> deleteGame(@PathVariable(value = "id") Long bookingID)
            throws ResourceNotFoundException {
        Booking booking = bookingRepository.findById(bookingID)
                .orElseThrow(() -> new ResourceNotFoundException("booking not found for this id :: " + bookingID));

        bookingRepository.delete(booking);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
