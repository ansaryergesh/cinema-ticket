package com.rent.Rental.System.Api.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBooking {
    private List<Booking> userBooking;

    public UserBooking() {
    }

    public UserBooking(List<Booking> userBooking) {
        this.userBooking = userBooking;
    }
}
