package main;

import Book.Book;
import main.App;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<Book> booklist = new ArrayList();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice;

        boolean valid_option = false;
        do {
            do {
                choice = App.start().toLowerCase().charAt(0);
                if (choice != 's' && choice != 'a' && choice != 'd' && choice != 'm' && choice != 'f' && choice != 'q') {
                    System.out.println("Wrong input, try again");
                    valid_option = false;
                } else
                    valid_option = true;
            } while (valid_option != true);

            if (choice == 'a') {
                App.addBook(booklist);
            } else if (choice == 's') {
                App.displayArray(booklist);
            } else if (choice == 'm') {
                App.chooseObject(booklist);
            } else if (choice == 'f') {
                App.displayArray(booklist);
                App.allInfo(booklist);
            } else if (choice == 'd') {
                App.displayArray(booklist);
                App.deleteBook(booklist);
            }
        } while (choice != 'q');
        scan.close();
    }
}