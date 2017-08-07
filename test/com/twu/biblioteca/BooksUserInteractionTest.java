package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class BooksUserInteractionTest {


    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        final Scanner scanner = new Scanner("1,t");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);

        userInteractions.printBooksInStock();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("3   To Kill a Mockingbird                         Harper Lee           1813"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }


    @Test
    public void showListOfBooks() throws IOException {

        final Scanner scanner = new Scanner("");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);

        userInteractions.printBooksInStock();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }


    @Test
    public void printTheMessageWhenSuccessfullyCheckedOutTheBook() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);
        userInteractions.checkOutBook();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Thank you! Enjoy the book\n"));
        Assert.assertFalse(output.contains("That book is not available."));
    }

    @Test
    public void printTheMessageWhenUnsuccessfullyCheckedOutTheBook() throws IOException {

        Scanner scanner = new Scanner("The Book Thier,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);
        userInteractions.checkOutBook();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("That book is not available.\n"));
        Assert.assertFalse(output.contains("Thank you! Enjoy the book\n"));
    }

    @Test
    public void printMessageWhenReturnedBookSuccessfully() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);
        Book book = new Book("The Book Thief", "Markus Badach", "2005");

        userInteractions.bookBibliotecaApp.checkOut(book);
        userInteractions.returnBook();

        final String output = outputBuffer.toString();
        Assert.assertTrue(output.contains("Thank you for returning the book."));
        Assert.assertFalse(output.contains("That is not a valid book to return."));
    }

    @Test
    public void printMessageWhenReturnedBookUnsuccessfully() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badch,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        BooksUsersInteractions userInteractions = new BooksUsersInteractions(scanner, out);
        Book book = new Book("The Book Thief", "Markus Badach", "2005");

        userInteractions.bookBibliotecaApp.checkOut(book);
        userInteractions.returnBook();

        final String output = outputBuffer.toString();
        Assert.assertFalse(output.contains("Thank you for returning the book."));
        Assert.assertTrue(output.contains("That is not a valid book to return."));
    }
}
