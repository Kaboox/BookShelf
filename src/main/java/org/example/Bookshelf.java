package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {
    private static ArrayList<Book> books  = new ArrayList<Book>();

    public static  boolean viewOptions() {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        System.out.println("A - add new book");
        System.out.println("V - view all books");
        System.out.println("D - delete selected book");
        System.out.println("M - view more details about a book");
        System.out.println("Q - close");

        choice = scan.nextLine().toUpperCase();


        if(choice.equals("Q")) {
            return false;
        }
        if(choice.equals("A")) {
            addBook();
        } else if (choice.equals("V")) {
            displayBooks();
        } else if(choice.equals("D")) {
            deleteBook();
        } else if(choice.equals("M")) {
            viewDetails();
        }

        return true;
    }

    public static void addBook() {
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

    public static void displayBooks() {
        if(books.size() == 0) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            for (Book book: books) {
                System.out.println(book.getTitle());
            }
        }
    }

    public static void deleteBook() {
        Scanner scan = new Scanner(System.in);
        if (books.size() == 0) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            System.out.println("Which book would you like to delete? ");
            displayBooks();
            System.out.println("Pass the number in the list (starting from 1): ");
            int indexToDelete = scan.nextInt();
            books.remove(indexToDelete);
        }
    }

    public static void viewDetails() {
        if(books.size() == 0) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select the number of the book, you wanna see: ");
            displayBooks();
            int index_of_choice = scan.nextInt();
            System.out.println(books.get(index_of_choice));
        }
    }
}
