package kz.iitu.jd3.bookrequest;

import lombok.Getter;
import lombok.Setter;

public class MovieRequest {

    private String userId;
    private Movie movie;

    public MovieRequest() {
    }

    public MovieRequest(String userId, Movie movie) {
        this.userId = userId;
        this.movie = movie;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                "userId='" + userId + '\'' +
                ", movie=" + movie +
                '}';
    }
}
