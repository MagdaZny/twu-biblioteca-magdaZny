package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MoviesUserInteractionsTest {

    @Test
    public void printMoviesInStockT() throws IOException {

        final Scanner scanner = new Scanner("4,t");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MoviesUserInteractions userInteractions = new MoviesUserInteractions(scanner, out);

        userInteractions.printMoviesInStock();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games (Movie)                                Suzanne Collins      2008    3"));
        Assert.assertTrue(output.contains("10  The Da Vinci Code (Movie)                               Dan Brown            2003    6"));
    }


    @Test
    public void printTheMessageWhenSuccessfullyCheckedOutTheMovie() throws IOException {

        Scanner scanner = new Scanner("The Book Thief (Movie),Markus Badach,2005");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        MoviesUserInteractions userInteractions = new MoviesUserInteractions(scanner, out);
        userInteractions.checkOutMovie();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Thank you! Enjoy the movie\n"));
        Assert.assertFalse(output.contains("That movie is not available."));
    }


    @Test
    public void printTheMessageWhenUnsuccessfullyCheckedOutTheMovie() throws IOException {

        Scanner scanner = new Scanner("The Book Thier,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        MoviesUserInteractions userInteractions = new MoviesUserInteractions(scanner, out);
        userInteractions.checkOutMovie();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("That movie is not available.\n"));
        Assert.assertFalse(output.contains("Thank you! Enjoy the movie\n"));
    }

    @Test
    public void printMessageWhenReturnedMovieSuccessfully() throws IOException {

        Scanner scanner = new Scanner("The Book Thief (Movie),Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        MoviesUserInteractions userInteractions = new MoviesUserInteractions(scanner, out);
        Movie movie = new Movie("The Book Thief (Movie)", "2005", "Markus Badach", "8");

        userInteractions.moviesBibliotecaApp.checkOut(movie);
        userInteractions.returnMovie();

        final String output = outputBuffer.toString();
        Assert.assertTrue(output.contains("Thank you for returning the movie."));
        Assert.assertFalse(output.contains("That is not a valid movie to return."));
    }

        @Test
        public void printMessageWhenReturnedMovieUnsuccessfully() throws IOException {

            Scanner scanner = new Scanner("The Book Thief (Mo),Markus Badach,2005,Quit");
            scanner.useDelimiter(",");

            ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(outputBuffer);

            MoviesUserInteractions userInteractions = new MoviesUserInteractions(scanner, out);
            Movie movie = new Movie("The Book Thief (Movie)", "2005", "Markus Badach", "8");

            userInteractions.moviesBibliotecaApp.checkOut(movie);
            userInteractions.returnMovie();

            final String output = outputBuffer.toString();
            Assert.assertFalse(output.contains("Thank you for returning the movie."));
            Assert.assertTrue(output.contains("That is not a valid movie to return."));
        }
    }
