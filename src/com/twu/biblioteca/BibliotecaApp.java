package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    private String[] booksInStock;

    BibliotecaApp() throws IOException {

        String file = new File("src/resources/books.csv").getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        booksInStock = new String[16];
        String line;

        for (int i = 0; i < 16; i++) {
            line = bufferedReader.readLine();
            String[] book = line.split(",");
            booksInStock[i] = book[0];
        }
    }

    public static void main(String[] args) throws IOException {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        System.out.println("Welcome to The Bangalore Public Library system.\n");
        printBooksInStock();
    }

    public void printBooksInStock() {
        for (int i = 0; i < booksInStock.length; i++){
            System.out.println(i+1 + ". " +booksInStock[i]);
        }
    }

}
