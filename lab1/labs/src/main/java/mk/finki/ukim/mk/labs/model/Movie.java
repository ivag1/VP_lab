package mk.finki.ukim.mk.labs.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    Long id;
    String title;
    String summary;
    double rating;

    public Movie(String title, String summary, double rating){
        this.title = title;
        this.summary = summary;
        this.rating = rating;
    }
}
