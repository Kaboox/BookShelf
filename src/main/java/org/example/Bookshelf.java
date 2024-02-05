package org.example;

import java.util.ArrayList;

public class Bookshelf {
    private ArrayList<Book> books  = new ArrayList<Book>();

    public static void viewOptions() {
        System.out.println("A - add new book");
        System.out.println("V - view all books");
        System.out.println("D - delete selected book");
        System.out.println("M - view more details about a book");
    }
}
