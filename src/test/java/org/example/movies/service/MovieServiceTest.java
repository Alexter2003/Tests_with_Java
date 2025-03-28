package org.example.movies.service;

import org.example.movies.data.MovieRepository;
import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {

    MovieRepository movieRepository;
    @Before
    public void setup() {
        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "The Shawshank Redemption", 130, Genre.HORROR),
                        new Movie(2, "The Godfather", 105, Genre.DRAMA),
                        new Movie(3, "The Godfather: Part II", 110, Genre.DRAMA),
                        new Movie(4, "The Dark Knight", 120, Genre.ACTION),
                        new Movie(5, "12 Angry Men", 135, Genre.DRAMA)
                )
        );
    }

    @Test
    public void find_movies_by_genre() {
        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.HORROR);

        List<Integer> moviesID = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(moviesID, CoreMatchers.is(Arrays.asList(1)));
    }

    @Test
    public void find_movies_by_length() {

        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByLength(120);

        List<Integer> moviesID = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(moviesID, CoreMatchers.is(Arrays.asList(2, 3, 4)));
    }

}