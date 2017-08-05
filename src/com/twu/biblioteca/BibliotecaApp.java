package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> booksInStock;
    private List<Book> booksCheckedOut;

    BibliotecaApp() throws IOException {

        booksCheckedOut = new ArrayList();

        FileParser fileParser = new FileParser();
        booksInStock = fileParser.addBooksToTheList();
    }

    public void checkOutTheBook(Book book) {

        if (isBookInStock(book)) {
            booksInStock.remove(book);
            booksCheckedOut.add(book);
        }
    }

    public Boolean isBookInStock(Book book) {
        return (booksInStock .contains(book));
    }


    public void returnTheBook(Book book) {

        if (isBookCheckedOut(book)) {
            booksCheckedOut.remove(book);
            booksInStock.add(book);
        }
    }

    public Boolean isBookCheckedOut(Book book) {
        return booksCheckedOut.contains(book);
    }


    public List<Book> getBooksInStock() {
        return booksInStock;
    }


    public List<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }



}

