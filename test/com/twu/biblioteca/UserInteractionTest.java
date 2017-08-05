package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteractionTest {

    @Test
    public void printWelcomeMessageWhenStartApp() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        UserInteractions userInteractions = new UserInteractions(scanner, out);

        userInteractions.start();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Welcome to The Bangalore Public Library system."));
    }

    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        UserInteractions userInteractions = new UserInteractions(scanner, out);

        userInteractions.printBooksInStock();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("2   Harry Potter and the Order of the Phoenix     J.K. Rowling         2004"));
        Assert.assertTrue(output.contains("3   To Kill a Mockingbird                         Harper Lee           1813"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMainMenu() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        UserInteractions userInteractions = new UserInteractions(scanner, out);

        userInteractions.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Main Menu\n"));
    }

    @Test
    public void showListOfBooksWhenChooseOptionOne() throws IOException {

        final Scanner scanner = new Scanner("n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        UserInteractions userInteractions = new UserInteractions(scanner, out);

        userInteractions.printBooksInStock();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMessageWhenInvalidOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("4,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        UserInteractions userInteractions = new UserInteractions(scanner, out);
        userInteractions.decideTheOption();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Select a valid option!"));
    }

    @Test
    public void terminateWhenQuitOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("Quit");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        UserInteractions userInteractions = new UserInteractions(scanner, out);

        userInteractions.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Type 'Quit' if you want to leave.\n"));
    }

    @Test
    public void printTheMessageWhenSuccessfullyCheckedOutTheBook() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        UserInteractions userInteractions = new UserInteractions(scanner, out);
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

        UserInteractions userInteractions = new UserInteractions(scanner, out);
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

        UserInteractions userInteractions = new UserInteractions(scanner, out);
        Book book = new Book("The Book Thief", "Markus Badach", "2005");

        userInteractions.bibliotecaApp.checkOutTheBook(book);
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

        UserInteractions userInteractions = new UserInteractions(scanner, out);
        Book book = new Book("The Book Thief", "Markus Badach", "2005");

        userInteractions.bibliotecaApp.checkOutTheBook(book);
        userInteractions.returnBook();

        final String output = outputBuffer.toString();
        Assert.assertFalse(output.contains("Thank you for returning the book."));
        Assert.assertTrue(output.contains("That is not a valid book to return."));
    }
}
