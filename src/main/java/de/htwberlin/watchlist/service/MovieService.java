package de.htwberlin.watchlist.service;

import de.htwberlin.watchlist.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {
    private final OmdbService omdbService;
    private final List<Movie> movies = new ArrayList<>();

    public MovieService(OmdbService omdbService) {
        this.omdbService = omdbService;
        movies.add(new Movie(1L, "Inception", "Sci-Fi", 2010, true, "Anna", "Unbedingt zweimal schauen!", null));
        movies.add(new Movie(2L, "The Lives of Others", "Drama", 2006, true, "Max", "Sehr spannend, spielt in Berlin.", null));
        movies.add(new Movie(3L, "Intouchables", "Komödie", 2011, true, "Mama", "Perfekt für einen entspannten Abend.", null));

    }

    public List<Movie> getAll() {
        movies.forEach(this::loadRating);
        return movies;
    }

    public Optional<Movie> getById(Long id) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
        movie.ifPresent(this::loadRating);
        return movie;
    }


    private void loadRating(Movie movie) {
        if (movie.getImdbRating() == null) {

            movie.setImdbRating(omdbService.findImdbRating(movie.getTitle(), movie.getReleaseYear()));
        }
    }
}