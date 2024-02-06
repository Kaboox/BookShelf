package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {
    private ArrayList<Book> books  = new ArrayList<Book>();

    public static  boolean viewOptions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("A - add new book");
        System.out.println("V - view all books");
        System.out.println("D - delete selected book");
        System.out.println("M - view more details about a book");
        System.out.println("Q - close");
        String choice = scan.nextLine().toUpperCase();

        if(choice.equals("Q")) {

            return false;
        }
        return true;
    }

    public void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's title: ");
        String title = scan.nextLine();
        System.out.println("Pass in the book's author: ");
        String author = scan.nextLine();
        System.out.println("Pass in the book's genre: ");
        String genre = scan.nextLine();
        System.out.println("Pass in the books's release year: ");
        int release_year = scan.nextInt();

        books.add(new Book(title, author, genre, release_year));
    }
}
