package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.moviesapi.MovieFixtures;
import org.superbiz.moviefun.moviesapi.MovieInfo;
import org.superbiz.moviefun.moviesapi.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesRepository;
    private final MovieFixtures movieFixtures;

    public HomeController(MoviesClient moviesRepository, MovieFixtures movieFixtures) {
        this.moviesRepository = moviesRepository;
        this.movieFixtures = movieFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesRepository.addMovie(movie);
        }


        model.put("movies", moviesRepository.getMovies());

        return "setup";
    }
}
