package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static com.twu.biblioteca.MenuOptionsEnum.*;

public class MainMenu {

    public IOUtil io;
    public BibliotecaApp bibliotecaApp;

    public MainMenu(Scanner scanner, PrintStream out) throws IOException {

        bibliotecaApp = new BooksBibliotecaApp();
        io = new IOUtil(scanner, out);
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

    public void decideTheOption() {

        String choice = io.next();

        if (LIST_BOOKS.returnId().equals(choice)) printBooksInStock();
        else if (CHECK_OUT_BOOK.returnId().equals(choice)) checkOutBook();
        else if (RETURN_BOOK.returnId().equals(choice)) returnBook();
        else if ("Quit".equalsIgnoreCase(choice)) return;
        else {
            io.println("Select a valid option!");
            decideTheOption();
        }
    }

    public void checkOutBook() {

        Book bookDetailsFromUser = getBooksDetailsFromUser("check out");

        if (bibliotecaApp.isInStock(bookDetailsFromUser)) {
            bibliotecaApp.checkOut(bookDetailsFromUser);
            printCheckOutMessage(true);
        } else printCheckOutMessage(false);
    }


    public void returnBook() {

        Book bookDetailsFromUser = getBooksDetailsFromUser("return");

        if (bibliotecaApp.isCheckedOut(bookDetailsFromUser)) {
            bibliotecaApp.returnTheItem(bookDetailsFromUser);
            printReturnBookMessage(true);
        } else printReturnBookMessage(false);
    }


    public void printBooksInStock() {

        io.printf("%-3s %-45s %-20s %-4s\n", "No", "Title", "Author", "Year");
        for (int i = 0; i < 75; i++)
            io.print("-");
        io.println("");
        for (int i = 0; i < bibliotecaApp.getTheItemsInStock().size(); i++)
            io.printf("%-3d %-45s %-20s %-4s\n", i + 1, bibliotecaApp.getTheItemsInStock().get(i).getTitle(), bibliotecaApp.getTheItemsInStock().get(i).getAuthor(), bibliotecaApp.getTheItemsInStock().get(i).getYear());
        io.println("\n");
        if (io.readString("Do you want to go to the Main Menu?  Press 'y' to confirm.").equals("y")) showMainMenu();
    }


    public void showMainMenu() {

        io.println("Main Menu\n----------\n\nPlease select the option by typing the corresponding number.");
        io.printf("%-3s %-10s\n", LIST_BOOKS.returnId(), LIST_BOOKS.toString());
        io.printf("%-3s %-10s\n", CHECK_OUT_BOOK.returnId(), CHECK_OUT_BOOK.toString());
        io.printf("%-3s %-10s\n", RETURN_BOOK.returnId(), RETURN_BOOK.toString());
        io.println("\n\n\nType 'Quit' if you want to leave.");


    }

    public Book getBooksDetailsFromUser(String activity) {

        Book bookDetailsFromUser = new Book();

        io.println("In order to " + activity + " a book please provide the following details.");
        bookDetailsFromUser.setTitle(io.readString("\ntitle"));
        bookDetailsFromUser.setAuthor(io.readString("\nauthor"));
        bookDetailsFromUser.setYear(io.readString("\nyear"));

        return bookDetailsFromUser;
    }

    public void printCheckOutMessage(Boolean isCheckOutSuccessfull) {

        if (isCheckOutSuccessfull) {
            io.println("Thank you! Enjoy the book\n");
        } else io.println("\nThat book is not available.\n\n");
    }


    public void printReturnBookMessage(Boolean isReturnedSuccessfully) {
        if (isReturnedSuccessfully) {
            io.println("\nThank you for returning the book.\n\n");
        } else
            io.println("\nThat is not a valid book to return.\n\n");
    }

}


