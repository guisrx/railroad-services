package com.selau.thoughtworks.railroad;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(final String args[]) throws FileNotFoundException {

        // final Scanner inputScanner = new Scanner(new FileInputStream(args[0]));
        final Scanner inputScanner = new Scanner(System.in);

        int size = inputScanner.nextInt();
        String number = inputScanner.next();

        while ((size != 0) && (number != "0")) {

            final char[][] display = builder.build(size, number);
            builder.print(display);

            System.out.println("");

            size = inputScanner.nextInt();
            number = inputScanner.next();
        }
        inputScanner.close();

        System.exit(0);
    }


}
