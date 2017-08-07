package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainMenuTest {

    @Test
    public void printWelcomeMessageWhenStartApp() throws IOException {

        final Scanner scanner = new Scanner("Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        MainMenu userInteractions = new MainMenu(scanner, out);

        userInteractions.start();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Welcome to The Bangalore Public Library system."));
    }

    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        final Scanner scanner = new Scanner("1,t");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu mainMenu = new MainMenu(scanner, out);

        mainMenu.start();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("3   To Kill a Mockingbird                         Harper Lee           1813"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMainMenu() throws IOException {

        final Scanner scanner = new Scanner("1,y,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu userInteractions = new MainMenu(scanner, out);

        userInteractions.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Main Menu\n"));
    }

    @Test
    public void showListOfBooksWhenChooseOptionOne() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu mainMenu = new MainMenu(scanner, out);

        mainMenu.start();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMessageWhenInvalidOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("9,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu userInteractions = new MainMenu(scanner, out);
        userInteractions.decideTheOption();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Select a valid option!"));
    }

    @Test
    public void terminateWhenQuitOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("Quit");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu userInteractions = new MainMenu(scanner, out);

        userInteractions.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Type 'Quit' if you want to leave.\n"));
    }

    @Test
    public void showListOfMoviesWhenChooseOptionOne() throws IOException {

        final Scanner scanner = new Scanner("4,t");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        MainMenu mainMenu = new MainMenu(scanner, out);

        mainMenu.start();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games (Movie)                                Suzanne Collins      2008    3"));
        Assert.assertTrue(output.contains("10  The Da Vinci Code (Movie)                               Dan Brown            2003    6"));
    }

}
