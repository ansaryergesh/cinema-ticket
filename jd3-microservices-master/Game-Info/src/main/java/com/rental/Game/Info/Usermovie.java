package com.rental.Game.Info;

import lombok.Setter;
import lombok.Getter;

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
