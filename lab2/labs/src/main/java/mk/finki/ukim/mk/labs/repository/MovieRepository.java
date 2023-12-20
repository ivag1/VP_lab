package mk.finki.ukim.mk.labs.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.labs.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init(){
        movies.add(new Movie("Movie 1","Summary 1", 9.2));
        movies.add(new Movie("Movie 2","Summary 2", 7.1));
        movies.add(new Movie("Movie 3","Summary 3", 4.6));
        movies.add(new Movie("Movie 4","Summary 4", 8.0));
        movies.add(new Movie("Movie 5","Summary 5", 8.8));
        movies.add(new Movie("Movie 6","Summary 6", 6.5));
        movies.add(new Movie("Movie 7","Summary 7", 7.9));
        movies.add(new Movie("Movie 8","Summary 8", 7.8));
        movies.add(new Movie("Movie 9","Summary 9", 8.5));
        movies.add(new Movie("Movie 10","Summary 10", 5.8));
    }

    public List<Movie> findAll(){
        return movies;
    }

    public List<Movie> searchMovies(String text){
        return movies.stream().filter(m->m.getTitle().contains(text)||m.getSummary().contains(text)).collect(Collectors.toList());
    }


    public List<Movie> searchMoviesByTitleAndRating(String text,String rating){
        return movies.stream().filter(m->m.getTitle().contains(text)&&m.getRating()==Double.parseDouble(rating)).collect(Collectors.toList());
    }

    public List<Movie> searchByTitle(String text){
        return movies.stream().filter(m->m.getTitle().contains(text)).collect(Collectors.toList());
    }

    public List<Movie> searchByRating(String rating){
        return movies.stream().filter(m->m.getRating()==Double.parseDouble(rating)).collect(Collectors.toList());
    }


}
