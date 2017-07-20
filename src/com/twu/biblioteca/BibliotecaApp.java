package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private IOUtil io;
    private List<List<String>> booksInStock;
    private List<List<String>> booksCheckedOut;


    BibliotecaApp(Scanner scanner, PrintStream out) throws IOException {

        io = new IOUtil(scanner, out);

        String file = new File("src/resources/books.csv").getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        booksInStock = new ArrayList();
        booksCheckedOut = new ArrayList();
        String line;

        for (int i = 0; i < 16; i++) {
            line = bufferedReader.readLine();
            String[] book = line.split(",");

            List<String> row = new ArrayList();
            row.add(book[0]);
            row.add(book[1]);
            row.add(book[2]);
            booksInStock.add(i, row);
        }
    }


    public void start() {

        io.println("Welcome to The Bangalore Public Library system.");
        for (int i = 0; i < 47; i++) {
            io.print("=");
        }
        io.println("\n");

        showMainMenu();
    }


    public void printBooksInStock() {

        io.printf("%-3s %-45s %-20s %-4s\n", "No", "Title", "Author", "Year");
        for (int i = 0; i < 75; i++)
            io.print("-");
        io.println("");
        for (int i = 0; i < booksInStock.size(); i++)
            io.printf("%-3d %-45s %-20s %-4s\n", i + 1, booksInStock.get(i).get(0), booksInStock.get(i).get(1), booksInStock.get(i).get(2));
        io.println("\n");
        if (io.readString("Do you want to go to the Main Menu?  Press 'y' to confirm.").equals("y")) showMainMenu();
    }


    public void showMainMenu() {

        io.println("Main Menu\n----------\n\nPlease select the option by typing the corresponding number.");
        io.printf("%-3d %-10s\n", 1, "List Books");
        io.printf("%-3d %-10s\n", 2, "Check out a book");
        io.printf("%-3d %-10s\n", 3, "Return a book");
        io.println("\n\n\nType 'Quit' if you want to leave.");

        decideTheOption();

    }

    private void decideTheOption() {

        String choice = io.next();
        if ("1".equals(choice)) printBooksInStock();
        else if ("2".equals(choice)) checkOutTheBook();
        else if ("3".equals(choice)) returnTheBook();
        else if ("Quit".equalsIgnoreCase(choice)) return;
        else {
            io.println("Select a valid option!");
            decideTheOption();
        }
    }


    public void checkOutTheBook() {

        List<String> book = getBooksDetailsFromTheConsole("check out");

        if (booksInStock.contains(book)) {
            booksInStock.remove(book);
            booksCheckedOut.add(book);
            io.println("\nThank you! Enjoy the book\n\n");
        } else io.println("\nThat book is not available.\n\n");
        showMainMenu();
    }

    public void returnTheBook() {

        List<String> book = getBooksDetailsFromTheConsole("return");

        if (booksCheckedOut.contains(book)) {
            booksCheckedOut.remove(book);
            booksInStock.add(book);
            io.println("\nThank you for returning the book.\n\n");
        } else io.println("\nThat is not a valid book to return.\n\n");
        showMainMenu();
    }

    private List<String> getBooksDetailsFromTheConsole(String activity) {

        List<String> bookDetails = new ArrayList();

        io.println("In order to " + activity + " a book please provide the following details.");
        bookDetails.add(0, io.readString("\ntitle"));
        bookDetails.add(1, io.readString("\nauthor"));
        bookDetails.add(2, io.readString("\nyear"));

        return bookDetails;
    }


    public List<List<String>> getBooksInStock() {
        return booksInStock;
    }


    public List<List<String>> getBooksCheckedOut() {
        return booksCheckedOut;
    }


    public void checkOutTheBook(List<String> bookInStock) {
        this.booksInStock.remove(bookInStock);
        this.booksCheckedOut.add(bookInStock);
    }
}

