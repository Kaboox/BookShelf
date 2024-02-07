package org.example;
import org.example.Bookshelf.*;

public class Main {
    public static void main(String[] args) {


        boolean working = true;
        System.out.println("Hello and welcome to your private BookShelf. What would you like to do?");
        while(working) {
            working = Bookshelf.viewOptions();
        }

    }


}