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
    public void printBooksInStock() throws IOException {

        bibliotecaApp.printBooksInStock();

        String output[] = systemOutRule.getLog().split("\n");
        assertEquals("1. The Hunger Games", output[0]);
        assertEquals("2. Harry Potter and the Order of the Phoenix", output[1]);
        assertEquals("3. To Kill a Mockingbird", output[2]);
        assertEquals("16. The Da Vinci Code", output[15]);
    }
}



