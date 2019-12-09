package com.rental.Game.Info;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    public Movie() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Movie(String cinema, String dateFilm, String description, String janre, String name, Integer price, String image) {
        this.cinema = cinema;
        this.dateFilm = dateFilm;
        this.description = description;
        this.janre = janre;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    private String cinema;
    private String dateFilm;
    private String description;
    private String janre;
    private String name;
    private Integer price;
    private String image;


    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getDateFilm() {
        return dateFilm;
    }

    public void setDateFilm(String dateFilm) {
        this.dateFilm = dateFilm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJanre() {
        return janre;
    }

    public void setJanre(String janre) {
        this.janre = janre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
