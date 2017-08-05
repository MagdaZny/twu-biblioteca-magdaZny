package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class BibliotecaAppTest {


    @Test
    public void removeBookFromTheListAndAddToCheckedOutListWhenWasCheckedOut() throws IOException {

        BibliotecaApp app = new BibliotecaApp();
        Book book = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOutTheBook(book);

        Assert.assertFalse(app.getBooksInStock().contains(book));
        Assert.assertTrue(app.getBooksCheckedOut().contains(book));
    }


    @Test
    public void checkOutTwoBooks() throws IOException {

        BibliotecaApp app = new BibliotecaApp();

        Book book1 = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOutTheBook(book1);
        Book book2 = new Book("The Chronicles of Narnia", "C.S. Lewis", "1956");
        app.checkOutTheBook(book2);

        List<Book> booksCheckedOut = app.getBooksCheckedOut();
        List<Book> booksInStock = app.getBooksInStock();

        Assert.assertTrue(booksCheckedOut.contains(book1));
        Assert.assertTrue(booksCheckedOut.contains(book2));
        Assert.assertFalse(booksInStock.contains(book1));
        Assert.assertFalse(booksInStock.contains(book2));
    }


    @Test
    public void addBookToBooksInStockListAndRemoveFromCheckedOutWhenWasReturned() throws IOException {

        final BibliotecaApp app = new BibliotecaApp();

        Book book = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOutTheBook(book);
        Assert.assertFalse(app.getBooksInStock().contains(book));
        Assert.assertTrue(app.getBooksCheckedOut().contains(book));

        app.returnTheBook(book);
        Assert.assertTrue(app.getBooksInStock().contains(book));
        Assert.assertTrue(app.getBooksCheckedOut().isEmpty());
    }
}




