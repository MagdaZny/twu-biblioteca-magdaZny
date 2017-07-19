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
            booksInStock.add(i,row);
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
        for (int i = 0; i < booksInStock.size(); i++)
            io.printf("%-3d %-45s %-20s %-4s\n", i + 1, booksInStock.get(i).get(0), booksInStock.get(i).get(1), booksInStock.get(i).get(2));
    }

    public void showMainMenu() {

        io.println("Main Menu\n----------\nPlease select the option:");
        io.printf("%-3d %-10s\n", 1, "List Books");
        io.printf("%-3d %-10s\n", 2, "Check out a book");

        io.print("\n\n\nType 'Quit' if you want to leave.\n");

        String choice = io.next();

        if ("1".equals(choice)) printBooksInStock();
        else if ("2".equals(choice)) checkOut();
        else if ("Quit".equalsIgnoreCase(choice)) return;
        else io.println("Select a valid option!");
    }

    public void checkOut() {

        io.println("In order to check out a book please provide the following details.");
        String title = io.readString("title\n");
        String author = io.readString("author\n");
        String year = io.readString("year\n");

        for (List<String> book: booksInStock){
            if (title.equals(book.get(0)) && author.equals(book.get(1)) && year.equals(book.get(2))){
                booksInStock.remove(book);
                booksCheckedOut.add(book);
                io.println("Thank you! Enjoy the book");
                break;
            }
        }
    }

    public List<List<String>> getBooksInStock() {
        return booksInStock;
    }


    public List<List<String>> getBooksCheckedOut() {
        return booksCheckedOut;
    }
}

