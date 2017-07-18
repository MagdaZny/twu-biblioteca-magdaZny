package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BibliotecaApp {

    private String[][] booksInStock;

    BibliotecaApp() throws IOException {

        String file = new File("src/resources/books.csv").getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        booksInStock = new String[16][3];
        String line;

        for (int i = 0; i < 16; i++) {
            line = bufferedReader.readLine();
            String[] book = line.split(",");
            booksInStock[i][0] = book[0];
            booksInStock[i][1] = book[1];
            booksInStock[i][2] = book[2];
        }
    }

    public static void main(String[] args) throws IOException {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {

        System.out.println("Welcome to The Bangalore Public Library system.");
        for (int i = 0; i < 47; i++) {
            System.out.print("=");
        }
        System.out.println("\n");

        printBooksInStock();
    }

    public void printBooksInStock() {

        System.out.printf("%-3s %-45s %-20s %-4s\n", "No", "Title", "Author", "Year");
        for (int i = 0; i < 75; i++)
            System.out.print("-");
        System.out.println("");
        for (int i = 0; i < booksInStock.length; i++)
            System.out.printf("%-3d %-45s %-20s %-4s\n", i+1, booksInStock[i][0], booksInStock[i][1], booksInStock[i][2]);
    }
}

