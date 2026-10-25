package de.htwberlin.watchlist.web;

import de.htwberlin.watchlist.model.Movie;
import de.htwberlin.watchlist.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService)
        {
        this.movieService = movieService;
        }
    @GetMapping(path = "/movies")
    public ResponseEntity<List<Movie>> GetAllMovies() {

            return
                    ResponseEntity.ok(movieService.getAll());
        }

        @GetMapping(path = "/movies/{id}")
                public ResponseEntity<Movie>
                getMovie(@PathVariable Long id) {
            return movieService.getById(id)
                    .map(ResponseEntity::ok)

                    .orElse(ResponseEntity.notFound().build());
    }
    }

