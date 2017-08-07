package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class BooksUsersInteractions extends UserInteractions {

    public BooksUsersInteractions(Scanner scanner, PrintStream out) throws IOException {
        super(scanner, out);
    }


    public void printBooksInStock() {

        io.printf("%-3s %-45s %-20s %-4s\n", "No", "Title", "Author", "Year");
        for (int i = 0; i < 75; i++)
            io.print("-");
        io.println("");
        for (int i = 0; i < bookBibliotecaApp.getTheItemsInStock().size(); i++)
            io.printf("%-3d %-45s %-20s %-4s\n", i + 1, bookBibliotecaApp.getTheItemsInStock().get(i).getTitle(), bookBibliotecaApp.getTheItemsInStock().get(i).getAuthor(), bookBibliotecaApp.getTheItemsInStock().get(i).getYear());
        io.println("\n");
    }


    public Book getBooksDetailsFromUser(String activity) {

        Book bookDetailsFromUser = new Book();

        io.println("In order to " + activity + " a book please provide the following details.");
        bookDetailsFromUser.setTitle(io.readString("\ntitle"));
        bookDetailsFromUser.setAuthor(io.readString("\nauthor"));
        bookDetailsFromUser.setYear(io.readString("\nyear"));

        return bookDetailsFromUser;
    }


    private void printCheckOutMessage(Boolean isCheckOutSuccessfull) {

        if (isCheckOutSuccessfull) {
            io.println("Thank you! Enjoy the book\n");
        } else io.println("\nThat book is not available.\n\n");
    }


    private void printReturnBookMessage(Boolean isReturnedSuccessfully) {
        if (isReturnedSuccessfully) {
            io.println("\nThank you for returning the book.\n\n");
        } else
            io.println("\nThat is not a valid book to return.\n\n");
    }


    public void checkOutBook() {

        Book bookDetailsFromUser = getBooksDetailsFromUser("check out");

        if (bookBibliotecaApp.isInStock(bookDetailsFromUser)) {
            bookBibliotecaApp.checkOut(bookDetailsFromUser);
            printCheckOutMessage(true);
        } else printCheckOutMessage(false);
    }


    public void returnBook() {

        Book bookDetailsFromUser = getBooksDetailsFromUser("return");

        if (bookBibliotecaApp.isCheckedOut(bookDetailsFromUser)) {
            bookBibliotecaApp.returnTheItem(bookDetailsFromUser);
            printReturnBookMessage(true);
        } else printReturnBookMessage(false);
    }

}
