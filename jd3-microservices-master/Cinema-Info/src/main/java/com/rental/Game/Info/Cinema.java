package com.rental.Game.Info;

import javax.persistence.*;

@Entity
@Table(name="cinema")
public class Cinema {
    public Cinema(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Cinema(String cinema, String image, String description, String city) {
        this.cinema = cinema;
        this.image = image;
        this.description = description;
        this.city = city;
    }

    private String cinema;
    private String image;
    private String description;
    private String city;

    public Long getId() {
        return id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


