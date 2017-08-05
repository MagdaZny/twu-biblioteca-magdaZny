package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public List<Book> addBooksToTheList() throws IOException {

        String file = new File("src/resources/books.csv").getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;

        List<Book> listOfBooks = new ArrayList();

        int totalNumberOfBooks = 16;

        for (int i = 0; i < totalNumberOfBooks; i++) {
            Book book = new Book();
            line = bufferedReader.readLine();
            String[] lineArray = line.split(",");

            book.setTitle(lineArray[0]);
            book.setAuthor(lineArray[1]);
            book.setYear(lineArray[2]);
            listOfBooks.add(book);
        }
        return listOfBooks;
    }
}
