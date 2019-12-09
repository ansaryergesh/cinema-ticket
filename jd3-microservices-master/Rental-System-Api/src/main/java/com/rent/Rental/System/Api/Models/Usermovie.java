package com.rent.Rental.System.Api.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Usermovie {
    private List<Movie> userMovies;

    public Usermovie() {
    }

    public Usermovie(List<Movie> userMovies) {
        this.userMovies = userMovies;
    }
}
