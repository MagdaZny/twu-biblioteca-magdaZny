package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesBibliotecaApp extends BibliotecaApp<Movie> {

    MoviesBibliotecaApp() throws IOException {

        checkedOut = new ArrayList();
        stock = addMoviesToTheList();
    }


    private List<Movie> addMoviesToTheList() throws IOException {

        String file = new File("src/resources/movies.csv").getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;

        List<Movie> listOfMovies = new ArrayList();

        int totalNumberOfMovies = 10;

        for (int i = 0; i < totalNumberOfMovies; i++) {
            Movie movie = new Movie();
            line = bufferedReader.readLine();
            String[] lineArray = line.split(",");

            movie.setName(lineArray[0]);
            movie.setDirector(lineArray[1]);
            movie.setYear(lineArray[2]);
            movie.setRating(lineArray[3]);
            listOfMovies.add(movie);
        }
        return listOfMovies;
    }
}
