package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {
    private ArrayList<Book> books  = new ArrayList<Book>();

    public static void viewOptions() {
        System.out.println("A - add new book");
        System.out.println("V - view all books");
        System.out.println("D - delete selected book");
        System.out.println("M - view more details about a book");
        System.out.println("Q - close");
    }

    public void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's title: ");
        String title = scan.nextLine();

        books.add(new Book(title));
    }
}
