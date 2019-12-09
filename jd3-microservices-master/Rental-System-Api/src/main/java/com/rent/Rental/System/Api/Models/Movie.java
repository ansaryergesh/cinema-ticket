package com.rent.Rental.System.Api.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Movie {
    public Movie() {
    }

    public Movie(String name, String janre, String dateFilm, String cinema, String description, Integer price, String image) {
        this.name = name;
        this.janre = janre;
        this.dateFilm = dateFilm;
        this.cinema = cinema;
        this.description = description;
        this.price = price;
        this.image = image;

    }

    private Long id;

    private String name;
    private String janre;
    private String dateFilm;
    private String cinema;
    private String description;
    private Integer price;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJanre() {
        return janre;
    }

    public String getDateFilm() {
        return dateFilm;
    }

    public String getCinema() {
        return cinema;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJanre(String janre) {
        this.janre = janre;
    }

    public void setDateFilm(String dateFilm) {
        this.dateFilm = dateFilm;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
