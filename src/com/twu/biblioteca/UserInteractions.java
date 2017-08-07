package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInteractions {

    public IOUtil io;
    public BooksBibliotecaApp bookBibliotecaApp;
    public MoviesBibliotecaApp moviesBibliotecaApp;
    public PrintStream out;


    UserInteractions (Scanner scanner, PrintStream out) throws IOException {
        io = new IOUtil(scanner, out);
        bookBibliotecaApp = new BooksBibliotecaApp();
        moviesBibliotecaApp = new MoviesBibliotecaApp();
    }
}


