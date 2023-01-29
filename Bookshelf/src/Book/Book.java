package Book;

import java.util.ArrayList;
import java.util.Scanner;


public class Book {
    static Scanner scan = new Scanner(System.in);
    private String title;
    private String author;
    private String genre;
    private boolean completed;
    private int rating;

    // constructors
    public Book() {};
    public Book(String title, String author, String genre, boolean completed) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.completed = completed;
    }
    public Book(String title, String author, String genre, boolean completed, int rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.completed = completed;
        this.rating = rating;
    }

    // getters
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getGenre() {
        return this.genre;
    }
    public boolean getCompleted() {
        return this.completed;
    }
    public int getRating() {
        return this.rating;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Title: " + getTitle() + ", author: " + getAuthor() + ", genre: " + getGenre() + ", completion status: " + getCompleted() + ", rating: " + getRating();
    }
}

