package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class IOUtil {
    private final Scanner in;
    private final PrintStream out;

    public IOUtil(Scanner scanner, PrintStream out) {
        this.in = scanner;
        this.out = out;
    }

    public String next() {
        return in.next();
    }

    public String readString(String message) {
        out.println(message);
        return in.next();
    }

    public void println(String message) {
        out.println(message);
    }

    public void print(String message){
        out.print(message);
    }

    public void printf(String s, String i, String s1) {
        out.printf(s, i, s1);
    }

    public void printf(String s, String no, String title, String author, String year) {
        out.printf(s, no, title, author, year);
    }

    public void printf(String s, int  no, String title, String author, String year) {
        out.printf(s, no, title, author, year);
    }

    public Scanner getIn() {
        return in;
    }

    public PrintStream getOut() {
        return out;
    }
}