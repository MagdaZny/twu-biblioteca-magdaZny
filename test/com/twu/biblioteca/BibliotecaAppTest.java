package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;

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
        assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
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

}



