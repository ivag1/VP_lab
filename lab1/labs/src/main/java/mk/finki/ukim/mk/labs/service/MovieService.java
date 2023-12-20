package mk.finki.ukim.mk.labs.service;

import mk.finki.ukim.mk.labs.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    public List<Movie> findAll();

    public List<Movie> searchMovies(String text);

    public List<Movie> searchMoviesByTitleAndRating(String text,String rating);

    public List<Movie> searchByRating(String rating);

    public List<Movie> searchByTitle(String text);
}
