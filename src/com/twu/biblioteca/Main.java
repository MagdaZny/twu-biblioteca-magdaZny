package com.twu.biblioteca;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        BibliotecaApp bibliotecaApp = new BibliotecaApp(scanner, System.out);
        bibliotecaApp.start();
    }
}
