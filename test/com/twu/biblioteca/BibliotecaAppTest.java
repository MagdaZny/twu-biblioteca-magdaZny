package com.twu.biblioteca;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    public BibliotecaAppTest() throws IOException {
    }

    @Test
    public void printWelcomeMessageWhenStartApp() throws IOException {

        bibliotecaApp.start();

        String output[] = systemOutRule.getLog().split("\n");
        assertEquals("Welcome to The Bangalore Public Library system.", output[0]);
    }

    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        bibliotecaApp.printBooksInStock();

        String output[] = systemOutRule.getLog().split("\n");
        assertEquals("1   The Hunger Games                              Suzanne Collins      2008", output[2]);
        assertEquals("2   Harry Potter and the Order of the Phoenix     J.K. Rowling         2004", output[3]);
        assertEquals("3   To Kill a Mockingbird                         Harper Lee           1813", output[4]);
        assertEquals("16  The Da Vinci Code                             Dan Brown            2003", output[17]);
    }

}



