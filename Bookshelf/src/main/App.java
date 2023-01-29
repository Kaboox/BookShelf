package main;

import Book.Book;

import java.util.ArrayList;
import java.util.Scanner;

// contains all methods used in main
public class App {
    static public String start() {
        String choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your Bookshelf, what would you like to do?");
        System.out.println("A - add new object to your shelf");
        System.out.println("S - display all present items");
        System.out.println("D - delete an item");
        System.out.println("M - modify item's properties");
        System.out.println("F - display all of the object's properties");
        System.out.println("Q - quit");
        choice = scan.next();
        return choice;
    }
    // methods to get user's input values for creating new item
    public static String askTitle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's title");
        String title = scan.nextLine();
        return title;

    }
    public static String askAuthor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's author");
        String author = scan.nextLine();
        return author;
    }
    public static String askGenre() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pass in the book's genre");
        String genre = scan.nextLine();
        return genre;

    }
    public static boolean askCompleted() {
        Scanner scan = new Scanner(System.in);
        boolean completion = false;
        char char_choice;
        System.out.println("Pass in y/n, regarding if you have finished the book already");
        do {
            String choice = scan.next();
            char_choice = choice.toLowerCase().charAt(0);

            if (char_choice != 'n' && char_choice != 'y')
                System.out.println("Wrong input,try again (y/n)");
        } while (char_choice != 'n' && char_choice != 'y');

        if (char_choice == 'n') {
            completion = false;
        } else if (char_choice == 'y') {
            completion = true;
        }
        return completion;
    }

    public static int askRating() {
        Scanner scan = new Scanner(System.in);
        int rating = -1;
        System.out.println("What do you rate the book? 0-10");

        do {
            try {
                String possible_rating = scan.next();
                if (Integer.parseInt(possible_rating) >= 0 && Integer.parseInt(possible_rating) <= 10)
                    rating = Integer.parseInt(possible_rating);
                else
                    System.out.println("Given input is not in range 0-10");
            } catch(NumberFormatException e) {
                System.out.println("Input is not an integer");
            }
        } while (rating < 0 || rating > 10);

        return rating;
    }
    // creater book and adds it to bookshelf
    public static void addBook(ArrayList<Book> booklist) {
        String title = askTitle();
        String author = askAuthor();
        String genre = askGenre();
        boolean completion = askCompleted();
        int rating;
        if (completion == true) {
            rating = askRating();
            booklist.add(new Book(title, author, genre, completion, rating));
        } else {
            booklist.add(new Book(title, author, genre, completion));
        }
    }
    // displays books
    public static void displayArray(ArrayList<Book> booklist) {
        System.out.print("[ ");
        for (Book book : booklist) {
            if (book instanceof Book) {
                System.out.print(book.getTitle());
                System.out.print(", ");
            } else {
                System.out.print(" ");
                System.out.print(", ");
            }

        }
        System.out.println(" ]");
    }
    // asks user to choose object to modify later with changeProperties method
    public static void chooseObject(ArrayList<Book> booklist) {
        System.out.println("Which object would you like to modify?");
        displayArray(booklist);
        System.out.println(" ");

        int chosenIndex = validationArraySize(booklist);
        changeProperties(chosenIndex, booklist);
    }
    // changes chosen properties of the book
    public static void changeProperties(int index, ArrayList<Book> booklist) {
        System.out.println("What property would you like to change? ");
        System.out.println("T - title");
        System.out.println("A - author");
        System.out.println("G - genre");
        System.out.println("C - completion");
        System.out.println("R - rating");
        char choice;
        do {
            Scanner scan = new Scanner(System.in);
            String strChoice = scan.next();
            choice = strChoice.toLowerCase().charAt(0);
        } while (choice != 't' && choice != 'a' && choice != 'g' && choice != 'c' && choice != 'r');
        if (choice == 't') {
            Scanner scan = new Scanner(System.in);
            System.out.println("Put in the new title");
            String title = scan.nextLine();
            booklist.get(index).setTitle(title);
        } else if (choice == 'a') {
            System.out.println("Put in the new author");
            Scanner scan = new Scanner(System.in);
            String author = scan.nextLine();
            booklist.get(index).setAuthor(author);
        } else if (choice == 'g') {
            System.out.println("Put in the new genre");
            Scanner scan = new Scanner(System.in);
            String genre = scan.nextLine();
            booklist.get(index).setGenre(genre);
        } else if (choice == 'c') {
            System.out.println("Put in the new completion status");
            Scanner scan = new Scanner(System.in);
            String completion = scan.next();
            if (completion.toLowerCase().charAt(0) == 'y') {
                booklist.get(index).setCompleted(true);
            } else if (completion.toLowerCase().charAt(0) == 'n') {
                booklist.get(index).setCompleted(false);
            }
        } else if (choice == 'r') {
            System.out.println("Put in the new rating");
            int rating = -1;
            do {
                try {
                    Scanner scan = new Scanner(System.in);
                    String possible_rating = scan.next();
                    if (Integer.parseInt(possible_rating) >= 0 && Integer.parseInt(possible_rating) <= 10)
                        rating = Integer.parseInt(possible_rating);
                    else
                        System.out.println("Given input is not in range 0-10");
                } catch(NumberFormatException e) {
                    System.out.println("Input is not an integer");
                }
            } while (rating < 0 || rating > 10);
            booklist.get(index).setRating(rating);
        }
    }
    // displays all properties of the given object
    public static void allInfo(ArrayList<Book> booklist) {
        int index = validationArraySize(booklist);
        System.out.println(booklist.get(index));
    }
    // deletes book from the shelf
    public static void deleteBook(ArrayList<Book> booklist) {
        System.out.println("Which item would you like to delete?");
        int index = validationArraySize(booklist);
        booklist.remove(index);
    }
    // validates if chosen index of the array is correct
    public static int validationArraySize(ArrayList<Book> booklist) {
        Scanner scan = new Scanner(System.in);
        int index = -1;
        String index_to_check;
        System.out.println("Choose the item");
        do {
            try {
                index_to_check = scan.next();
                if (Integer.parseInt(index_to_check) >= 0 && Integer.parseInt(index_to_check) < booklist.size()) {
                    index = Integer.parseInt(index_to_check);
                } else
                    System.out.println("Index is out of range");
            } catch (NumberFormatException e) {
                System.out.println("Input is not an integer");
            }
        } while (index < 0 || index > booklist.size());
        return index;
    }
}
