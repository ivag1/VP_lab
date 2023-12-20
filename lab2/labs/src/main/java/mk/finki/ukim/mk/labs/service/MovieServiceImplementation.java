package mk.finki.ukim.mk.labs.service;

import mk.finki.ukim.mk.labs.model.Movie;
import mk.finki.ukim.mk.labs.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImplementation(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    public List<Movie> searchMoviesByTitleAndRating(String text,String rating){return movieRepository.searchMoviesByTitleAndRating(text,rating);}

    @Override
    public List<Movie> searchByRating(String rating) {
        return movieRepository.searchByRating(rating);
    }

    @Override
    public List<Movie> searchByTitle(String text) {
        return movieRepository.searchByTitle(text);
    }


}
