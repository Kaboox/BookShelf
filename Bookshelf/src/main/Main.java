package main;

import Book.Book;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Bookshelf contains shelf with books, you can adjust it to your liking

public class Main {
    static ArrayList<Book> booklist = new ArrayList();
    static Scanner scan = new Scanner(System.in);
    static public String start() {
        String choice;
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
    public static void askTitle(){
            System.out.println("Pass in the book's title");
            String title = scan.next();
            //System.out.print(title);
            askAuthor(title);

    }
    public static void askAuthor(String title) {
        System.out.println("Pass in the book's author");
        String author = scan.next();
        askGenre(title, author);
    }
    public static void askGenre(String title, String author) {
        System.out.println("Pass in the book's genre");
        String genre = scan.next();
        askCompleted(title, author, genre);

    }
    public static void askCompleted(String title, String author, String genre) {
        boolean completion;
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
            booklist.add(new Book(title, author, genre, completion));
        } else if (char_choice == 'y') {
            completion = true;
            askRating(title, author, genre, completion);
        }
    }

    public static void askRating(String title, String author, String genre, boolean completion) {
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

        booklist.add(new Book(title, author, genre, completion, rating));

    }
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
    public static void chooseObject() {
        System.out.println("Which object would you like to modify?");
        displayArray(booklist);
        System.out.println(" ");

        int chosenIndex = validationArraySize();
        changeProperties(chosenIndex);
    }
    // changes chosen properties of the book
    public static void changeProperties(int index) {
        System.out.println("What property would you like to change? ");
        System.out.println("T - title");
        System.out.println("A - author");
        System.out.println("G - genre");
        System.out.println("C - completion");
        System.out.println("R - rating");
        char choice;
        do {
            String strChoice = scan.next();
            choice = strChoice.toLowerCase().charAt(0);
        } while (choice != 't' && choice != 'a' && choice != 'g' && choice != 'c' && choice != 'r');
        if (choice == 't') {
            System.out.println("Put in the new title");
            String title = scan.next();
            booklist.get(index).setTitle(title);
        } else if (choice == 'a') {
            System.out.println("Put in the new author");
            String author = scan.next();
            booklist.get(index).setAuthor(author);
        } else if (choice == 'g') {
            System.out.println("Put in the new genre");
            String genre = scan.next();
            booklist.get(index).setGenre(genre);
        } else if (choice == 'c') {
            System.out.println("Put in the new completion status");
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
    public static void allInfo() {
        int index = validationArraySize();
        System.out.println(booklist.get(index));
    }
    // deletes book from the shelf
    public static void deleteBook() {
        System.out.println("Which item would you like to delete?");
        int index = validationArraySize();
        booklist.remove(index);
    }
    public static void quit() {
        scan.close();
    }
    public static int validationArraySize() {
        int index = 100;
        String index_to_check;
        System.out.println("Choose the item");
        do {
            //try {
            try {
                index_to_check = scan.next();
                if (Integer.parseInt(index_to_check) >= 0 && Integer.parseInt(index_to_check) < booklist.size()) {
                    index = Integer.parseInt(index_to_check);
                } else
                    System.out.println("Index is out of range");
            } catch (NumberFormatException e) {
                System.out.println("Input is not an integer");
            }
            ;
            // } catch(IndexOutOfBoundsException a) {
            //System.out.println("Index out of range");
            //}
        } while (index < 0 || index > booklist.size());
        return index;
    }


    public static void main(String[] args) {
        char choice;
        booklist.add(new Book("Tadeusz12", "Zbigniew","Dramat",true,6));
        booklist.add(new Book("Tadeusz1251", "Zbigniew","Dramat",true,6));

        boolean valid_option = false;
        do {
            do {
                choice = start().toLowerCase().charAt(0);
                if (choice != 's' && choice != 'a' && choice != 'd' && choice != 'm' && choice != 'f' && choice != 'q') {
                    System.out.println("Wrong input, try again");
                    valid_option = false;
                } else
                    valid_option = true;
            } while (valid_option != true);

            if (choice == 'a') {
                askTitle();
                displayArray(booklist);

            } else if (choice == 's') {
                displayArray(booklist);
            } else if (choice == 'm') {
                chooseObject();

            } else if (choice == 'f') {
                displayArray(booklist);
                allInfo();
            } else if (choice == 'd') {
                displayArray(booklist);
                deleteBook();
                displayArray(booklist);
            } else if (choice == 'q') {
                quit();
                //break;
            }
        } while (choice != 'q');


    }
}