package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static com.twu.biblioteca.MenuOptionsEnum.*;

public class MainMenu {

    IOUtil io;
    BooksUsersInteractions booksUsersInteractions;
    MoviesUserInteractions moviesUserInteractions;

    MainMenu(Scanner scanner, PrintStream out) throws IOException {
        io = new IOUtil(scanner, out);
        booksUsersInteractions = new BooksUsersInteractions(scanner, out);
        moviesUserInteractions = new MoviesUserInteractions(scanner, out);
    }


    public void start() {

        String welcomeMessage = "Welcome to The Bangalore Public Library system.";
        io.println(welcomeMessage);
        for (int i = 0; i < welcomeMessage.length(); i++) {
            io.print("=");
        }
        io.println("\n");

        showMainMenu();
        decideTheOption();
    }

    public void showMainMenu() {

        io.println("Main Menu\n----------\n\nPlease select the option by typing the corresponding number.");
        io.printf("%-3s %-10s\n", LIST_BOOKS.returnId(), LIST_BOOKS.toString());
        io.printf("%-3s %-10s\n", CHECK_OUT_BOOK.returnId(), CHECK_OUT_BOOK.toString());
        io.printf("%-3s %-10s\n", RETURN_BOOK.returnId(), RETURN_BOOK.toString());
        io.printf("%-3s %-10s\n", LIST_MOVIES.returnId(), LIST_MOVIES.toString());
        io.printf("%-3s %-10s\n", CHECK_OUT_MOVIE.returnId(), CHECK_OUT_MOVIE.toString());
        io.printf("%-3s %-10s\n", RETURN_MOVIE.returnId(), RETURN_MOVIE.toString());
        io.println("\n\n\nType 'Quit' if you want to leave.");
    }

    public void decideTheOption() {

        String choice = io.next();

        if (LIST_BOOKS.returnId().equals(choice)) {
            booksUsersInteractions.printBooksInStock();
            if (io.readString("Do you want to go to the Main Menu?  Press 'y' to confirm.").equals("y"))
                showMainMenuAndDecideAnOption();
            else return;
        }
        else if (CHECK_OUT_BOOK.returnId().equals(choice)) {
            booksUsersInteractions.checkOutBook();
            showMainMenuAndDecideAnOption();
        }
        else if (RETURN_BOOK.returnId().equals(choice)) {
            booksUsersInteractions.returnBook();
            showMainMenuAndDecideAnOption();
        }
        else if (LIST_MOVIES.returnId().equals(choice)){
            moviesUserInteractions.printMoviesInStock();
            if (io.readString("Do you want to go to the Main Menu?  Press 'y' to confirm.").equals("y"))
                showMainMenuAndDecideAnOption();
            else return;
        }
        else if (CHECK_OUT_MOVIE.returnId().equals(choice)){
            moviesUserInteractions.checkOutMovie();
            showMainMenuAndDecideAnOption();
        }
        else if (RETURN_MOVIE.returnId().equals(choice)){
            moviesUserInteractions.returnMovie();
            showMainMenuAndDecideAnOption();
        }
        else if ("Quit".equalsIgnoreCase(choice)) return;
        else {
            io.println("Select a valid option!");
            decideTheOption();
        }
    }

    public void showMainMenuAndDecideAnOption(){
        showMainMenu();
        decideTheOption();
    }

}
