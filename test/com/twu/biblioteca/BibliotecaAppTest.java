package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class BibliotecaAppTest {


    @Test
    public void removeBookFromTheListAndAddToCheckedOutListWhenWasCheckedOut() throws IOException {

        BibliotecaApp app = new BooksBibliotecaApp();
        Book book = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOut(book);

        Assert.assertFalse(app.getTheItemsInStock().contains(book));
        Assert.assertTrue(app.getTheItemsCheckedOut().contains(book));
    }


    @Test
    public void checkOutTwoBooks() throws IOException {

        BibliotecaApp app = new BooksBibliotecaApp();

        Book book1 = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOut(book1);
        Book book2 = new Book("The Chronicles of Narnia", "C.S. Lewis", "1956");
        app.checkOut(book2);

        List<Book> booksCheckedOut = app.getTheItemsCheckedOut();
        List<Book> booksInStock = app.getTheItemsInStock();

        Assert.assertTrue(booksCheckedOut.contains(book1));
        Assert.assertTrue(booksCheckedOut.contains(book2));
        Assert.assertFalse(booksInStock.contains(book1));
        Assert.assertFalse(booksInStock.contains(book2));
    }


    @Test
    public void addBookToBooksInStockListAndRemoveFromCheckedOutWhenWasReturned() throws IOException {

        final BibliotecaApp app = new BooksBibliotecaApp();

        Book book = new Book("The Book Thief", "Markus Badach", "2005");
        app.checkOut(book);
        Assert.assertFalse(app.getTheItemsInStock().contains(book));
        Assert.assertTrue(app.getTheItemsCheckedOut().contains(book));

        app.returnTheItem(book);
        Assert.assertTrue(app.getTheItemsInStock().contains(book));
        Assert.assertTrue(app.getTheItemsCheckedOut().isEmpty());
    }

    @Test
    public void removeMovieFromTheListAndAddToCheckedOutListWhenWasCheckedOut() throws IOException {

        BibliotecaApp app = new MoviesBibliotecaApp();
        Movie movie = new Movie("The Book Thief (Movie)", "2005", "Markus Badach", "8");
        app.checkOut(movie);

        Assert.assertFalse(app.getTheItemsInStock().contains(movie));
        Assert.assertTrue(app.getTheItemsCheckedOut().contains(movie));
    }


    @Test
    public void checkOutTwoMovies() throws IOException {

        BibliotecaApp app = new MoviesBibliotecaApp();

        Movie movie1 = new Movie("The Book Thief (Movie)", "2005", "Markus Badach", "8");
        app.checkOut(movie1);
        Movie movie2 = new Movie("The Chronicles of Narnia (Movie)", "1956", "C.S. Lewis", "6");
        app.checkOut(movie2);

        List<Movie> moviesCheckedOut = app.getTheItemsCheckedOut();
        List<Movie> moviesInStock = app.getTheItemsInStock();

        Assert.assertTrue(moviesCheckedOut.contains(movie1));
        Assert.assertTrue(moviesCheckedOut.contains(movie2));
        Assert.assertFalse(moviesInStock.contains(movie1));
        Assert.assertFalse(moviesInStock.contains(movie2));
    }


    @Test
    public void addMovieToMoviesInStockListAndRemoveFromCheckedOutWhenWasReturned() throws IOException {

        final BibliotecaApp app = new MoviesBibliotecaApp();

        Movie movie = new Movie("The Book Thief (Movie)", "2005", "Markus Badach", "8");
        app.checkOut(movie);
        Assert.assertFalse(app.getTheItemsInStock().contains(movie));
        Assert.assertTrue(app.getTheItemsCheckedOut().contains(movie));

        app.returnTheItem(movie);
        Assert.assertTrue(app.getTheItemsInStock().contains(movie));
        Assert.assertTrue(app.getTheItemsCheckedOut().isEmpty());
    }
}




