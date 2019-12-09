package com.rent.Renting.Service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BookingTicket")
public class Booking {
    public Booking() {
    }

    public Booking(String userID, String movieID, String date, String cinema, Integer price,String seat) {
        this.userID = userID;
        this.movieID = movieID;
        this.date = date;
        this.cinema = cinema;
        this.price = price;
        this.seat = seat;
    }

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String userID;
    public String movieID;
    public String date;
    public String cinema    ;
    public Integer price;
    public String seat;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

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
