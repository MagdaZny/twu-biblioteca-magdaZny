package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaAppTest {


    @Test
    public void printWelcomeMessageWhenStartApp() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp bibliotecaApp = new BibliotecaApp(scanner, out);
        bibliotecaApp.start();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Welcome to The Bangalore Public Library system."));
    }

    @Test
    public void printBooksInStockTitlesWithAuthorAndYear() throws IOException {

        final Scanner scanner = new Scanner("1");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp bibliotecaApp = new BibliotecaApp(scanner, out);
        bibliotecaApp.printBooksInStock();
        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("2   Harry Potter and the Order of the Phoenix     J.K. Rowling         2004"));
        Assert.assertTrue(output.contains("3   To Kill a Mockingbird                         Harper Lee           1813"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMainMenu() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.startsWith("Main Menu\n"));
    }

    @Test
    public void showListOfBooksWhenChooseOptionOne() throws IOException {

        final Scanner scanner = new Scanner("1,n");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("1   The Hunger Games                              Suzanne Collins      2008"));
        Assert.assertTrue(output.contains("16  The Da Vinci Code                             Dan Brown            2003"));
    }

    @Test
    public void showMessageWhenInvalidOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("4,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Select a valid option!"));
    }

    @Test
    public void terminateWhenQuitOptionWasChosen() throws IOException {

        final Scanner scanner = new Scanner("Quit");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.showMainMenu();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Type 'Quit' if you want to leave.\n"));
    }


    @Test
    public void removeBookFromTheListAndAddToCheckedOutListWhenWasCheckedOut() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOutTheBook();

        final String output = outputBuffer.toString();

        List<List<String>> booksInStock = app.getBooksInStock();
        for (List<String> book : booksInStock) {
            Assert.assertFalse("Check that the book is not in a stock", ("The Book Thief".equals(book.get(0)) && "Markus Badach".equals(book.get(1)) && "2005".equals(book.get(2))));
        }
    }


    @Test
    public void addTheBookToCheckedOutListWhenWasCheckedOut() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOutTheBook();

        final String output = outputBuffer.toString();

        List<List<String>> bookCheckedOut = app.getBooksCheckedOut();
        for (List<String> book : bookCheckedOut) {
            Assert.assertTrue("Check that the book is in check out books list", ("The Book Thief".equals(book.get(0)) && "Markus Badach".equals(book.get(1)) && "2005".equals(book.get(2))));
        }
    }

    @Test
    public void printTheMessageWhenSuccessfullyCheckedOutTheBook() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOutTheBook();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("Thank you! Enjoy the book\n"));
        Assert.assertFalse(output.contains("That book is not available."));
    }


    @Test
    public void printTheMessageWhenUnsuccessfullyCheckedOutTheBook() throws IOException {

        Scanner scanner = new Scanner("The Book Thier,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOutTheBook();

        final String output = outputBuffer.toString();

        Assert.assertTrue(output.contains("That book is not available.\n"));
        Assert.assertFalse(output.contains("Thank you! Enjoy the book\n"));
    }


    @Test
    public void checkOutTwoBooks() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,2,The Chronicles of Narnia,C.S. Lewis,1956,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);
        app.checkOutTheBook();

        final String output = outputBuffer.toString();

        List<List<String>> booksCheckedOut = app.getBooksCheckedOut();
        List<List<String>> booksInStock = app.getBooksInStock();

        List<List<String>> inputBooks = new ArrayList();
        List<String> row = new ArrayList();
        inputBooks.add(row);
        row.add("The Book Thief");
        row.add("Markus Badach");
        row.add("2005");
        row = new ArrayList();
        inputBooks.add(row);
        row.add("The Chronicles of Narnia");
        row.add("C.S. Lewis");
        row.add("1956");

        Assert.assertFalse(booksCheckedOut.contains(inputBooks));
        Assert.assertEquals(booksCheckedOut, inputBooks);
    }

    @Test
    public void addBookToBooksInStockListAndRemoveFromCheckedOutWhenWasReturned() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);

        List<List<String>> inputBooks = new ArrayList();
        List<String> row = new ArrayList();
        row.add("The Book Thief");
        row.add("Markus Badach");
        row.add("2005");
        inputBooks.add(row);

        app.checkOutTheBook(row);


        Assert.assertFalse(app.getBooksInStock().containsAll(inputBooks));
        Assert.assertEquals(app.getBooksCheckedOut(), inputBooks);

        app.returnTheBook();

        final String output = outputBuffer.toString();

        Assert.assertTrue(app.getBooksInStock().containsAll(inputBooks));
        Assert.assertTrue(app.getBooksCheckedOut().isEmpty());
    }

    @Test
    public void printMessageWhenReturnedBookSuccessfully() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Markus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);

        List<List<String>> inputBooks = new ArrayList();
        List<String> row = new ArrayList();
        row.add("The Book Thief");
        row.add("Markus Badach");
        row.add("2005");
        inputBooks.add(row);

        app.checkOutTheBook(row);

        Assert.assertFalse(app.getBooksInStock().containsAll(inputBooks));
        Assert.assertEquals(app.getBooksCheckedOut(), inputBooks);

        app.returnTheBook();

        final String output = outputBuffer.toString();
        Assert.assertTrue(output.contains("Thank you for returning the book."));

        Assert.assertFalse(output.contains("That is not a valid book to return."));
    }

    @Test
    public void printMessageWhenReturnedBookUnsuccessfully() throws IOException {

        Scanner scanner = new Scanner("The Book Thief,Arkus Badach,2005,Quit");
        scanner.useDelimiter(",");

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);

        final BibliotecaApp app = new BibliotecaApp(scanner, out);

        List<List<String>> inputBooks = new ArrayList();
        List<String> row = new ArrayList();
        row.add("The Book Thief");
        row.add("Markus Badach");
        row.add("2005");
        inputBooks.add(row);

        app.checkOutTheBook(row);

        Assert.assertFalse(app.getBooksInStock().containsAll(inputBooks));
        Assert.assertEquals(app.getBooksCheckedOut(), inputBooks);

        app.returnTheBook();

        final String output = outputBuffer.toString();
        Assert.assertTrue(output.contains("That is not a valid book to return."));
        Assert.assertFalse(output.contains("Thank you for returning the book"));
    }
}




