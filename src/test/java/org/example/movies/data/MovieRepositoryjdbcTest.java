package org.example.movies.data;

import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryjdbcTest {

    MovieRepositoryjdbc movieRepositoryjdbc;
    DataSource dataSource;

    @Before
    public void setup() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MySQL", "root", "9122003");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryjdbc = new MovieRepositoryjdbc(jdbcTemplate);
    }


    @Test
    public void load_all_movies() throws SQLException {


        Collection<Movie> movies = movieRepositoryjdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION),
                new Movie(4, "The Matrix", 136, Genre.ACTION),
                new Movie(5, "The Matrix Reloaded", 136, Genre.ACTION)
                )));
    }

    @Test
    public void find_movie_by_id() {
        Movie movie = movieRepositoryjdbc.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void save_or_update_movie() {
        Movie movie = new Movie(6, "The Shawshank Redemption", 130, Genre.HORROR);
        movieRepositoryjdbc.saveOrUpdate(movie);

        Movie movieFromDB = movieRepositoryjdbc.findById(6);
        assertThat(movieFromDB, is(movie));
    }

    @Test
    public void find_movie_by_name() {
        Collection<Movie> movies = movieRepositoryjdbc.findByName("Matrix");

        assertThat(movies, is(Arrays.asList(
                new Movie(3, "Matrix", 136, Genre.ACTION),
                new Movie(4, "The Matrix", 136, Genre.ACTION),
                new Movie(5, "The Matrix Reloaded", 136, Genre.ACTION)
        )));

    }

    @After
    public void tearDown() throws Exception {
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute("Drop all objects delete files");
    }


}