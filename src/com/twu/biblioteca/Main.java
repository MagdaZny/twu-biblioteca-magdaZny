package com.twu.biblioteca;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        UserInteractions userInteractions = new UserInteractions(scanner, out);;
        userInteractions.start();

    }
}

