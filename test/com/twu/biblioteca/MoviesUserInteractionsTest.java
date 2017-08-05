package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MoviesUserInteractionsTest {


    @Test
    public void listMovies(){

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        MoviesUserInteractions moviesUserInteractions = new MoviesUserInteractions();

        moviesUserInteractions.printMoviesInStock();



    }
}
