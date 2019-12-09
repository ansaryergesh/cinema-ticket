package com.rent.Rental.System.Api.Models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Booking {
    public Booking() {
    }

    public Booking(String userID, String movieID, String date, String cinema, Integer price) {
        this.userID = userID;
        this.movieID = movieID;
        this.date = date;
        this.cinema = cinema;
        this.price = price;
    }


    private Long id;
    public String userID;
    public String movieID;
    public String date;
    public String cinema;
    public Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}