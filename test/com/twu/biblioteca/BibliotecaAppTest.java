package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BibliotecaAppTest {


    @Test
    public void printWelcomeMessageWhenStartApp() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp bibliotecaApp = new BibliotecaApp(scanner, out);
        bibliotecaApp.start();
        final String output = outputBuffer.toString();

        assertTrue(output.startsWith("Welcome to The Bangalore Public Library system."));
    }

    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp bibliotecaApp = new BibliotecaApp(scanner, out);
        bibliotecaApp.printBooksInStock();
        final String output = outputBuffer.toString();

        assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        assertTrue(output.contains("2   Harry Potter and the Order of the Phoenix     J.K. Rowling         2004"));
        assertTrue(output.contains("3   To Kill a Mockingbird                         Harper Lee           1813"));
        assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMainMenu() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        assertTrue(output.startsWith("Main Menu"));
    }

    @Test
    public void showListOfBooksWhenChooseOptionOne() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMessageWhenInvalidOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("3");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        assertTrue(output.contains("Select a valid option!"));
    }

    @Test
    public void terminateWhenQuitOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("quit");
        scanner.useDelimiter(" ");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        assertTrue(output.endsWith("Type 'Quit' if you want to leave.\n"));
    }


    @Test
    public void removeBookFromTheListWhenWasCheckedOut() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOut();

        final String output = outputBuffer.toString();

        List<List<String>> booksInStock = app.getBooksInStock();
        for(List<String> book: booksInStock){
            assertFalse("Check if the book is in stock", ("The Book Thief".equals(book.get(0)) && "Markus Badach".equals(book.get(1)) && "2005".equals(book.get(2))));
        }
    }

}



