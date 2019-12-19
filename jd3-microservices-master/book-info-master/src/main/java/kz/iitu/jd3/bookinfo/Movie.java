package kz.iitu.jd3.bookinfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    public Movie() {
    }

    public Movie(Long id, String name, String janre, String dateFilm, String cinema, String description, Integer price, String image) {
        this.id = id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJanre() {
        return janre;
    }

    public void setJanre(String janre) {
        this.janre = janre;
    }

    public String getDateFilm() {
        return dateFilm;
    }

    public void setDateFilm(String dateFilm) {
        this.dateFilm = dateFilm;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
