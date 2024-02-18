package org.example;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.println("F - modify chosen book's properties");
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
        } else if(choice.equals("F")) {
            modifyProperties();
        }

        return true;
    }

    public static void addBook() {
        String title;
        String author;
        String genre;
        int release_year;
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's title: ");
        do {
            title = scan.nextLine().trim();
        } while (title.isEmpty());
        System.out.println("Pass in the book's author: ");
        do {
            author = scan.nextLine().trim();
        } while (author.isEmpty());
        System.out.println("Pass in the book's genre: ");
        do {
            genre = scan.nextLine().trim();
        } while(genre.isEmpty());
        System.out.println("Pass in the book's release year: ");
        do {
            try {
                release_year = scan.nextInt();
                scan.nextLine(); // Consume the newline character
                if (release_year <= 0 || release_year > Year.now().getValue()) {
                    System.out.println("Invalid year. Please enter a valid year.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scan.nextLine(); // Consume the invalid input
                release_year = 0;
            }
        } while (release_year <= 0 || release_year > Year.now().getValue());


        books.add(new Book(title, author, genre, release_year));
    }

    public static void displayBooks() {
        if(books.isEmpty()) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            for (Book book: books) {
                System.out.println(book.getTitle());
            }
        }
    }

    public static void deleteBook() {
        Scanner scan = new Scanner(System.in);
        if (books.isEmpty()) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            System.out.println("Which book would you like to delete? ");
            displayBooks();
            System.out.println("Pass the number in the list (starting from 1): ");
            int indexToDelete;
            while(true) {
                try {
                    indexToDelete = Integer.parseInt(scan.nextLine());
                    if(indexToDelete >= 1 && indexToDelete <= books.size()) {
                        break; // valid input
                    } else {
                        System.out.println("Please choose index that exists in the list");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
            books.remove(indexToDelete-1);
        }
    }

    public static void viewDetails() {
        if(books.isEmpty()) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select the number of the book, you wanna see: ");
            displayBooks();
            int index_of_choice = scan.nextInt();
            System.out.println(books.get(index_of_choice-1));
        }
    }

    public static void modifyProperties() {
        int index_of_choice;
        if(books.isEmpty()) {
            System.out.println("Bookshelf is empty, add something first");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select the number of the book, you wanna modify: ");
            while(true) {
                try {
                    displayBooks();
                    index_of_choice = Integer.parseInt(scan.nextLine());
                    if(index_of_choice >= 1 && index_of_choice <= books.size()) {
                        break;
                    } else {
                        System.out.println("Wrong index");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            System.out.println("What property would you like to change?: ");
            System.out.println("T - title");
            System.out.println("A - author");
            System.out.println("G - genre");
            System.out.println("Y - year");
            String property_to_change;
            while(true) {
                property_to_change = scan.nextLine().toUpperCase();
                if(!property_to_change.equals("T") && !property_to_change.equals("A") &&
                        !property_to_change.equals("G") && !property_to_change.equals("Y")) {
                    System.out.println("Select between T/A/G/Y");
                } else {
                    break;
                }
            }
            switch (property_to_change) {
                case "T" -> {
                    System.out.println("Pass the new title: ");
                    String new_title = scan.nextLine();
                    books.get(index_of_choice-1).setTitle(new_title);
                }
                case "A" -> {
                    System.out.println("Pass the new author: ");
                    String new_author = scan.nextLine();
                    books.get(index_of_choice-1).setAuthor(new_author);
                }
                case "G" -> {
                    System.out.println("Pass the new genre: ");
                    String new_genre = scan.nextLine();
                    books.get(index_of_choice-1).setGenre(new_genre);
                }
                case "Y" -> {
                    System.out.println("Pass the new release year: ");
                    int new_year = scan.nextInt();
                    books.get(index_of_choice-1).setRelease_year(new_year);
                }
            }

        }

    }
}
