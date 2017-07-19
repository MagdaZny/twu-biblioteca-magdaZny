package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class BibliotecaApp {

    private final IOUtil io;
    private String[][] booksInStock;


    BibliotecaApp(Scanner scanner, PrintStream out) throws IOException {

        io = new IOUtil(scanner, out);

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


    public void start() {

        io.println("Welcome to The Bangalore Public Library system.");
        for (int i = 0; i < 47; i++) {
            io.print("=");
        }
        io.println("\n");        showMainMenu();
    }


    public void printBooksInStock() {

        io.printf("%-3s %-45s %-20s %-4s\n", "No", "Title", "Author", "Year");
        for (int i = 0; i < 75; i++)
            io.print("-");
        io.println("");
        for (int i = 0; i < booksInStock.length; i++)
            io.printf("%-3d %-45s %-20s %-4s\n", i + 1, booksInStock[i][0], booksInStock[i][1], booksInStock[i][2]);
    }

    public void showMainMenu() {

        io.println("Main Menu\n----------\nPlease select the option:");
        io.printf("%-3d %-10s\n", 1, "List Books");

        String choice = io.readString();

        if ("1".equals(choice)) printBooksInStock();
    }
}

