package edu.micoservices.moviescatalogservice.resources;

import edu.micoservices.moviescatalogservice.model.Movie;
import edu.micoservices.moviescatalogservice.model.MovieCataloge;
import edu.micoservices.moviescatalogservice.model.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<MovieCataloge> getCataloge(@PathVariable("userId") String userId){
        List<MovieRating> ratedMovies= Arrays.asList(
               new MovieRating("123",3),
               new MovieRating("456",4)
       );

       return ratedMovies.stream().map(movie->{
           Movie m=restTemplate.getForObject("http://localhost:8082/movie-info/"+movie.getMovieId(),Movie.class);
           return new MovieCataloge(m.getName(),"Desc",movie.getRating());
       }).collect(Collectors.toList());
    }
}
