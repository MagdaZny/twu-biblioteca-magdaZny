package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MoviesUserInteractions extends UserInteractions {

    public MoviesUserInteractions(Scanner scanner, PrintStream out) throws IOException {
        super(scanner, out);
    }

    public void printMoviesInStock(){
        io.printf("%-3s %-55s %-20s %-7s %-4s\n", "No", "Name", "Director", "Year", "Rating");
        for (int i = 0; i < 95; i++)
            io.print("-");
        io.println("");
        for (int i = 0; i < moviesBibliotecaApp.getTheItemsInStock().size(); i++)
            io.printf("%-3d %-55s %-20s %-7s %-4s\n", i + 1, moviesBibliotecaApp.getTheItemsInStock().get(i).getName(), moviesBibliotecaApp.getTheItemsInStock().get(i).getDirector(), moviesBibliotecaApp.getTheItemsInStock().get(i).getYear(), moviesBibliotecaApp.getTheItemsInStock().get(i).getRating());
        io.println("\n");
    }

    public void checkOutMovie() {
        Movie movieDetailsFromUser = getMovieDetailsFromUser("check out");

        if (moviesBibliotecaApp.isInStock(movieDetailsFromUser)) {
            moviesBibliotecaApp.checkOut(movieDetailsFromUser);
            printCheckOutMessage(true);
        } else printCheckOutMessage(false);

    }

    public void returnMovie() {

        Movie movieDetailsFromUser = getMovieDetailsFromUser("return");

        if (moviesBibliotecaApp.isCheckedOut(movieDetailsFromUser)) {
            moviesBibliotecaApp.returnTheItem(movieDetailsFromUser);
            printReturnMovieMessage(true);
        } else printReturnMovieMessage(false);
    }


    private Movie getMovieDetailsFromUser(String activity) {

        Movie movieDetailsFromUser = new Movie();

        io.println("In order to " + activity + " a movie please provide the following details.");
        movieDetailsFromUser.setName(io.readString("\nname"));
        movieDetailsFromUser.setDirector(io.readString("\ndirector"));
        movieDetailsFromUser.setYear(io.readString("\nyear"));

        return movieDetailsFromUser;
    }


    private void printCheckOutMessage(Boolean isCheckOutSuccessfull) {
        if (isCheckOutSuccessfull) {
            io.println("Thank you! Enjoy the movie\n");
        } else io.println("\nThat movie is not available.\n\n");
    }


    private void printReturnMovieMessage(Boolean isReturnedSuccessfully) {

        if (isReturnedSuccessfully) {
            io.println("\nThank you for returning the movie.\n\n");
        } else
            io.println("\nThat is not a valid movie to return.\n\n");
    }
}
